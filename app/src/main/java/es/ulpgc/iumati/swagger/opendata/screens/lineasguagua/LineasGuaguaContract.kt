package es.ulpgc.iumati.swagger.opendata.screens.lineasguagua

import androidx.lifecycle.LiveData
import es.ulpgc.iumati.swagger.opendata.screens.lineaguagua.LineaGuaguaData
import io.swagger.client.models.FeatureLineaGuagua

interface LineasGuaguaContract {

    interface View {
        var presenter: Presenter
    }

    interface Presenter {
        fun fetchLiveData(): LiveData<LineasGuaguaViewModel>
        fun navigateToNextScreen(feature: FeatureLineaGuagua)
    }

    interface Model {
        fun fetchBgLiveData(): LiveData<LineasGuaguaData>
    }

    interface Router {
        fun passDataToNextScreen(data: LineaGuaguaData)
        fun getDataFromPreviousScreen(): LineasGuaguaData?
        fun navigateToNextScreen()
    }

}
