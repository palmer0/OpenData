package es.ulpgc.iumati.swagger.opendata.screens.paradataxi

import androidx.lifecycle.LiveData

interface ParadaTaxiContract {

    interface View {
        var presenter: Presenter

    }

    interface Presenter {

        fun fetchLiveData(): LiveData<ParadaTaxiViewModel>
    }

    interface Model {
        fun setLiveData(data: ParadaTaxiData?)
        fun fetchBgLiveData(): LiveData<ParadaTaxiData>
    }

    interface Router {
        fun passDataToNextScreen(data: ParadaTaxiData)
        fun getDataFromPreviousScreen(): ParadaTaxiData?
        fun navigateToNextScreen()

    }

}
