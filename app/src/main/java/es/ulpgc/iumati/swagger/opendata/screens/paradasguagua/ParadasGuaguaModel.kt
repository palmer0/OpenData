package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.util.Log
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import es.ulpgc.iumati.swagger.opendata.OpenDataApi
import java.util.concurrent.Executors

import es.ulpgc.iumati.swagger.opendata.R
import io.swagger.client.models.FeatureParadaGuagua
import io.swagger.client.models.ParadasGuagua

data class ParadasGuaguaData(
  val features: Array<FeatureParadaGuagua>
  //var text: String? = null
)

class ParadasGuaguaModel(
  //var fragment: WeakReference<Fragment>? = null,
  var activity: WeakReference<FragmentActivity>? = null
) : ParadasGuaguaContract.Model {

  private val api = OpenDataApi()

  private val liveData = MutableLiveData<ParadasGuaguaData>()
  //private var text = "Hello"

  /*
  override fun fetchData(): ParadasGuaguaData? {
    Log.e(TAG, "fetchData()")

    fragment?.get()?.activity?.let { context ->

    }

    val data = ParadasGuaguaData(text)
    return data
  }
  */

  override fun fetchBgLiveData(): LiveData<ParadasGuaguaData> {

    // Execute work in background
    Executors.newSingleThreadExecutor().execute {
      //val data = ParadasGuaguaData(text)
      //liveData.postValue(data)

      api.fetchParadasGuagua(success = { features ->
        val data = ParadasGuaguaData(features)
        liveData.postValue(data)

      }, failure = { error ->

      })
    }

    return liveData
  }

//  override fun fetchLiveData(): LiveData<ParadasGuaguaData> {
//    Log.e(TAG, "fetchLiveData()")
//
//    val data = ParadasGuaguaData(text)
//    liveData.value = data
//
//    /*
//      activity?.get()?.let { context ->
//
//        context.resources?.let { resources ->
//          val data = ParadasGuaguaData(resources.getString(R.string.app_name))
//          liveData.value = data
//        }
//      }
//      */
//
//    return liveData
//  }

  companion object {
    const val TAG = "ParadasGuaguaModel"
  }
}
