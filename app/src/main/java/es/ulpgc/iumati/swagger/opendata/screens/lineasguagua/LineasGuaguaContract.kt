package es.ulpgc.iumati.swagger.opendata.screens.lineasguagua

import androidx.lifecycle.LiveData

interface LineasGuaguaContract {

    interface View {
        var presenter: Presenter
    }

    interface Presenter {
        fun fetchLiveData(): LiveData<LineasGuaguaViewModel>
    }

    interface Model {
        fun fetchBgLiveData(): LiveData<LineasGuaguaData>
    }

    interface Router {
        fun passDataToNextScreen(data: LineasGuaguaData?)
        fun getDataFromPreviousScreen(): LineasGuaguaData?
        fun navigateToNextScreen()
    }

}
