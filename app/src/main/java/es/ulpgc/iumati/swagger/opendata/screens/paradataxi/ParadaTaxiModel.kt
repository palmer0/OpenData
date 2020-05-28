package es.ulpgc.iumati.swagger.opendata.screens.paradataxi

import android.util.Log
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.Executors
import es.ulpgc.iumati.swagger.opendata.api.OpenDataApi

import es.ulpgc.iumati.swagger.opendata.R
import io.swagger.client.models.FeatureLineaGuagua
import io.swagger.client.models.FeatureParadaTaxi

data class ParadaTaxiData(
    val feature: FeatureParadaTaxi
)

class ParadaTaxiModel(
    var activity: WeakReference<FragmentActivity>? = null
) : ParadaTaxiContract.Model {

    private val api = OpenDataApi()
    private val liveData = MutableLiveData<ParadaTaxiData>()

    override fun fetchBgLiveData(): LiveData<ParadaTaxiData> {

        return liveData
    }

    override fun setLiveData(data: ParadaTaxiData?) {
        liveData.postValue(data)
    }

    companion object {
        const val TAG = "ParadaTaxiModel"
    }
}
