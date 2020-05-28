package es.ulpgc.iumati.swagger.opendata.screens.lineaguagua

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.swagger.client.models.FeatureLineaGuagua
import java.lang.ref.WeakReference

data class LineaGuaguaData(
    val feature: FeatureLineaGuagua
)

class LineaGuaguaModel(
    var activity: WeakReference<FragmentActivity>? = null
) : LineaGuaguaContract.Model {

    //private val api = OpenDataApi()
    private val liveData = MutableLiveData<LineaGuaguaData>()

    override fun fetchBgLiveData(): LiveData<LineaGuaguaData> {

        return liveData
    }

    override fun setLiveData(data: LineaGuaguaData?) {
        liveData.postValue(data)
    }


    companion object {
        const val TAG = "LineaGuaguaModel"
    }
}
