package es.ulpgc.iumati.swagger.opendata.screens.paradastaxi

import android.util.Log
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import es.ulpgc.iumati.swagger.opendata.screens.paradataxi.ParadaTaxiData
import io.swagger.client.models.FeatureLineaGuagua
import io.swagger.client.models.FeatureParadaTaxi

data class ParadasTaxiViewModel(
    var features: Array<FeatureParadaTaxi>
)

class ParadasTaxiPresenter : ParadasTaxiContract.Presenter {

    var activity: WeakReference<FragmentActivity>? = null

    var view: WeakReference<ParadasTaxiContract.View>? = null
    lateinit var state: ParadasTaxiState
    lateinit var model: ParadasTaxiContract.Model
    lateinit var router: ParadasTaxiContract.Router

    private val liveData = MutableLiveData<ParadasTaxiViewModel>()


    private fun updateState(newData: ParadasTaxiData?) {

        newData?.let { data ->
            state.data = data

            // Update the view
            val viewModel = ParadasTaxiViewModel(data.features)
            liveData.setValue(viewModel)
        }
    }

    override fun fetchLiveData(): LiveData<ParadasTaxiViewModel> {
        Log.e(TAG, "fetchLiveData()")

        /*
      // Fetch data from mediator
      (activity?.get()?.application as AppMediator).let { mediator ->

          //val data = mediator.data
          //updateState(data)
          model.setLiveData(mediator.data)
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

    override fun navigateToNextScreen(feature: FeatureParadaTaxi) {
        router.passDataToNextScreen(ParadaTaxiData(feature))
        router.navigateToNextScreen()
    }

    companion object {
        const val TAG = "ParadasTaxiPresenter"
    }
}
