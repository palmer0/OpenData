package es.ulpgc.iumati.swagger.opendata.screens.lineasguagua

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.ulpgc.iumati.swagger.opendata.api.OpenDataApi
import io.swagger.client.models.FeatureLineaGuagua
import java.lang.ref.WeakReference
import java.util.concurrent.Executors

data class LineasGuaguaData(
    val features: Array<FeatureLineaGuagua>
)

class LineasGuaguaModel(
    var activity: WeakReference<FragmentActivity>? = null
) : LineasGuaguaContract.Model {

    private val liveData = MutableLiveData<LineasGuaguaData>()

    private val api =
        OpenDataApi()

    override fun fetchBgLiveData(): LiveData<LineasGuaguaData> {

        // Execute work in background
        Executors.newSingleThreadExecutor().execute {
            api.fetchLineasGuagua(success = { features ->
                val data = LineasGuaguaData(features)
                liveData.postValue(data)

            }, failure = { error ->

            })
        }

        return liveData
    }


    companion object {
        const val TAG = "LineasGuaguaModel"
    }
}
