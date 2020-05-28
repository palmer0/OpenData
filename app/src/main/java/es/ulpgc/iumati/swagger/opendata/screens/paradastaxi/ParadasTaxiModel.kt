package es.ulpgc.iumati.swagger.opendata.screens.paradastaxi

import android.util.Log
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.Executors
import es.ulpgc.iumati.swagger.opendata.api.OpenDataApi

import es.ulpgc.iumati.swagger.opendata.R
import io.swagger.client.models.FeatureParadaTaxi

data class ParadasTaxiData(
    val features: Array<FeatureParadaTaxi>
)

class ParadasTaxiModel(
    var activity: WeakReference<FragmentActivity>? = null
) : ParadasTaxiContract.Model {

    private val api = OpenDataApi()
    private val liveData = MutableLiveData<ParadasTaxiData>()

    override fun fetchBgLiveData(): LiveData<ParadasTaxiData> {

        // Execute work in background
        Executors.newSingleThreadExecutor().execute {

            api.fetchParadasTaxi(success = { features ->
                val data = ParadasTaxiData(features)
                liveData.postValue(data)

            }, failure = { error ->

            })
        }

        return liveData
    }

    override fun setLiveData(data: ParadasTaxiData?) {
        liveData.postValue(data)
    }

    companion object {
        const val TAG = "ParadasTaxiModel"
    }
}
