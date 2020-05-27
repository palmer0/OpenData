package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import androidx.lifecycle.LiveData

interface ParadasGuaguaContract {

    interface View {
        var presenter: Presenter
    }

    interface Presenter {
        fun fetchLiveData(): LiveData<ParadasGuaguaViewModel>
    }

    interface Model {
        fun fetchBgLiveData(): LiveData<ParadasGuaguaData>
    }

    interface Router {
        fun passDataToNextScreen(data: ParadasGuaguaData?)
        fun getDataFromPreviousScreen(): ParadasGuaguaData?
        fun navigateToNextScreen()
    }

}
