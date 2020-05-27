package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.util.Log
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.swagger.client.models.FeatureParadaGuagua

data class ParadasGuaguaViewModel(
  var features: Array<FeatureParadaGuagua>
  //var text: String? = null
)

class ParadasGuaguaPresenter : ParadasGuaguaContract.Presenter {

  var activity: WeakReference<FragmentActivity>? = null
  //var fragment: WeakReference<Fragment>? = null

  var view: WeakReference<ParadasGuaguaContract.View>? = null
  lateinit var state: ParadasGuaguaState
  lateinit var model: ParadasGuaguaContract.Model
  lateinit var router: ParadasGuaguaContract.Router

  private val liveData = MutableLiveData<ParadasGuaguaViewModel>()

  /*
  override fun fetchData() {
    Log.e(TAG, "fetchData()")

    // Call the model
    state.data = model.fetchData()

    // Set data with state passed from other screen
    val newData = router.getDataFromPreviousScreen()
    newData?.let { data ->
      state.data = data
    }

    state.data?.text?.let { text ->

      // Update the view
      val viewModel = ParadasGuaguaViewModel(text)
      view?.get()?.displayData(viewModel)
    }

  }
  */

  /*
  private fun updateState(newData: ParadasGuaguaData?) {

    newData?.let { data ->
      state.data = data

      data.text?.let { text ->

        // Update the view
        val viewModel = ParadasGuaguaViewModel(text)
        liveData.setValue(viewModel)
      }
    }
  }
  */

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
          mediator.fetchLiveData()
              .observe(context, Observer<ParadasGuaguaData> { data ->

            updateState(data)
          })
        }
      }
      */

    /*
    // Call the model
    activity?.get()?.let { context ->
      model.fetchLiveData().observe(context, Observer { data ->

          updateState(data)
        })
    }
    */

    // Call the model
    activity?.get()?.let { context ->
      model.fetchBgLiveData().observe(context, Observer { data ->

          updateState(data)
        })
    }

    /*
    fragment?.get()?.let { context ->

    }
    */

    return liveData
  }

  companion object {
    const val TAG = "ParadasGuaguaPresenter"
  }
}
