package es.ulpgc.iumati.swagger.opendata.screens.lineaguagua

import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import es.ulpgc.iumati.swagger.opendata.app.AppMediator
import io.swagger.client.models.FeatureLineaGuagua
import java.lang.ref.WeakReference

data class LineaGuaguaViewModel(
    var feature: FeatureLineaGuagua
)

class LineaGuaguaPresenter : LineaGuaguaContract.Presenter {

    var activity: WeakReference<FragmentActivity>? = null

    var view: WeakReference<LineaGuaguaContract.View>? = null
    lateinit var state: LineaGuaguaState
    lateinit var model: LineaGuaguaContract.Model
    lateinit var router: LineaGuaguaContract.Router

    private val liveData = MutableLiveData<LineaGuaguaViewModel>()


    private fun updateState(newData: LineaGuaguaData?) {

        newData?.let { data ->
            state.data = data

            // Update the view
            val viewModel = LineaGuaguaViewModel(data.feature)
            liveData.setValue(viewModel)
        }
    }

    override fun fetchLiveData(): LiveData<LineaGuaguaViewModel> {
        Log.e(TAG, "fetchLiveData()")

        // Fetch data from mediator
        (activity?.get()?.application as AppMediator).let { mediator ->

            //val data = mediator.data
            //updateState(data)
            model.setLiveData(mediator.lineaGuagua)
        }

        // Call the model
        activity?.get()?.let { context ->
            model.fetchBgLiveData().observe(context, Observer { data ->

                updateState(data)
            })
        }

        return liveData
    }

    companion object {
        const val TAG = "LineaGuaguaPresenter"
    }
}
