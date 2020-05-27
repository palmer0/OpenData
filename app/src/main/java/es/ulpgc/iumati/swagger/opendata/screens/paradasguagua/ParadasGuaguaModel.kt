package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import es.ulpgc.iumati.swagger.opendata.api.OpenDataApi
import io.swagger.client.models.FeatureParadaGuagua
import java.lang.ref.WeakReference
import java.util.concurrent.Executors

data class ParadasGuaguaData(
    val features: Array<FeatureParadaGuagua>
)

class ParadasGuaguaModel(
    var activity: WeakReference<FragmentActivity>? = null
) : ParadasGuaguaContract.Model {

    private val api =
        OpenDataApi()

    private val liveData = MutableLiveData<ParadasGuaguaData>()

    override fun fetchBgLiveData(): LiveData<ParadasGuaguaData> {

        // Execute work in background
        Executors.newSingleThreadExecutor().execute {

            api.fetchParadasGuagua(success = { features ->
                val data = ParadasGuaguaData(features)
                liveData.postValue(data)

            }, failure = { error ->

            })
        }

        return liveData
    }

    companion object {
        const val TAG = "ParadasGuaguaModel"
    }
}
