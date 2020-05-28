package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.swagger.client.models.FeatureParadaGuagua
import java.lang.ref.WeakReference

data class ParadasGuaguaViewModel(
    val features: Array<FeatureParadaGuagua>
)

class ParadasGuaguaPresenter : ParadasGuaguaContract.Presenter {

    var activity: WeakReference<FragmentActivity>? = null

    var view: WeakReference<ParadasGuaguaContract.View>? = null
    lateinit var state: ParadasGuaguaState
    lateinit var model: ParadasGuaguaContract.Model
    lateinit var router: ParadasGuaguaContract.Router

    private val liveData = MutableLiveData<ParadasGuaguaViewModel>()

    private fun updateState(newData: ParadasGuaguaData?) {

        newData?.let { data ->
            state.data = data

            // Update the view
            val viewModel = ParadasGuaguaViewModel(data.features)
            liveData.setValue(viewModel)

        }
    }

    override fun fetchLiveData(): LiveData<ParadasGuaguaViewModel> {
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
            model.fetchBgLiveData().observe(context, Observer { data ->

                updateState(data)
            })
        }

        return liveData
    }

    companion object {
        const val TAG = "ParadasGuaguaPresenter"
    }
}
