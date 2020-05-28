package es.ulpgc.iumati.swagger.opendata.screens.paradataxi

import android.util.Log
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import es.ulpgc.iumati.swagger.opendata.app.AppMediator
import io.swagger.client.models.FeatureParadaTaxi

data class ParadaTaxiViewModel(
    var feature: FeatureParadaTaxi
)

class ParadaTaxiPresenter : ParadaTaxiContract.Presenter {

    var activity: WeakReference<FragmentActivity>? = null

    var view: WeakReference<ParadaTaxiContract.View>? = null
    lateinit var state: ParadaTaxiState
    lateinit var model: ParadaTaxiContract.Model
    lateinit var router: ParadaTaxiContract.Router

    private val liveData = MutableLiveData<ParadaTaxiViewModel>()


    private fun updateState(newData: ParadaTaxiData?) {

        newData?.let { data ->
            state.data = data

            // Update the view
            val viewModel = ParadaTaxiViewModel(data.feature)
            liveData.setValue(viewModel)
        }
    }

    override fun fetchLiveData(): LiveData<ParadaTaxiViewModel> {
        Log.e(TAG, "fetchLiveData()")

          // Fetch data from mediator
          (activity?.get()?.application as AppMediator).let { mediator ->

              model.setLiveData(mediator.paradaTaxi)
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
        const val TAG = "ParadaTaxiPresenter"
    }
}
