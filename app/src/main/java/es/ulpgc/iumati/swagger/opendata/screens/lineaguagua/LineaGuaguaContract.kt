package es.ulpgc.iumati.swagger.opendata.screens.lineaguagua

import androidx.lifecycle.LiveData

interface LineaGuaguaContract {

    interface View {
        var presenter: Presenter

    }

    interface Presenter {

        fun fetchLiveData(): LiveData<LineaGuaguaViewModel>
    }

    interface Model {

        fun fetchBgLiveData(): LiveData<LineaGuaguaData>
        fun setLiveData(data: LineaGuaguaData?)
    }

    interface Router {
        fun passDataToNextScreen(data: LineaGuaguaData?)
        fun getDataFromPreviousScreen(): LineaGuaguaData?
        fun navigateToNextScreen()

    }

}
