package es.ulpgc.iumati.swagger.opendata.screens.paradastaxi

import androidx.lifecycle.LiveData
import es.ulpgc.iumati.swagger.opendata.screens.paradataxi.ParadaTaxiData
import io.swagger.client.models.FeatureLineaGuagua
import io.swagger.client.models.FeatureParadaTaxi

interface ParadasTaxiContract {

    interface View {
        var presenter: Presenter

    }

    interface Presenter {

        fun fetchLiveData(): LiveData<ParadasTaxiViewModel>
        fun navigateToNextScreen(feature: FeatureParadaTaxi)
    }

    interface Model {
        fun setLiveData(data: ParadasTaxiData?)
        fun fetchBgLiveData(): LiveData<ParadasTaxiData>
    }

    interface Router {
        fun passDataToNextScreen(data: ParadaTaxiData)
        fun getDataFromPreviousScreen(): ParadasTaxiData?
        fun navigateToNextScreen()

    }

}
