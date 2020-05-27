package es.ulpgc.iumati.swagger.opendata.screens.lineasguagua

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.swagger.client.models.FeatureLineaGuagua
import java.lang.ref.WeakReference

data class LineasGuaguaViewModel(
    val features: Array<FeatureLineaGuagua>
)

class LineasGuaguaPresenter : LineasGuaguaContract.Presenter {

    var activity: WeakReference<FragmentActivity>? = null

    var view: WeakReference<LineasGuaguaContract.View>? = null
    lateinit var state: LineasGuaguaState
    lateinit var model: LineasGuaguaContract.Model
    lateinit var router: LineasGuaguaContract.Router

    private val liveData = MutableLiveData<LineasGuaguaViewModel>()


    private fun updateState(newData: LineasGuaguaData?) {

        newData?.let { data ->
            state.data = data

            // Update the view
            val viewModel = LineasGuaguaViewModel(data.features)
            liveData.setValue(viewModel)
        }
    }

    override fun fetchLiveData(): LiveData<LineasGuaguaViewModel> {
        Log.e(TAG, "fetchLiveData()")

        /*
        // Fetch data from mediator
        (activity?.get()?.application as AppMediator).let { mediator ->

            //val data = mediator.data
            //updateState(data)

            activity?.get()?.let { context ->
                mediator.fetchLiveData().observe(context, Observer { data ->

                        updateState(data)
                    })
            }
        }
        */

        // Call the model
        activity?.get()?.let { context ->
            model.fetchBgLiveData()
                .observe(context, Observer { data ->

                    updateState(data)
                })
        }

        return liveData
    }

    companion object {
        const val TAG = "LineasGuaguaPresenter"
    }
}
