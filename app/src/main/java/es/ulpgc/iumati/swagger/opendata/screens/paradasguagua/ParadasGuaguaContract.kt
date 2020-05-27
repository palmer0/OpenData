package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import androidx.lifecycle.LiveData

interface ParadasGuaguaContract {

  interface View {
    var presenter: Presenter
    //fun displayData(viewModel: ParadasGuaguaViewModel)
  }

  interface Presenter {
    //fun fetchData()
    fun fetchLiveData(): LiveData<ParadasGuaguaViewModel>
  }

  interface Model {
    //fun fetchData(): ParadasGuaguaData?
    //fun fetchLiveData(): LiveData<ParadasGuaguaData>
    fun fetchBgLiveData(): LiveData<ParadasGuaguaData>
  }

  interface Router {
    fun passDataToNextScreen(data: ParadasGuaguaData?)
    fun getDataFromPreviousScreen(): ParadasGuaguaData?
    fun navigateToNextScreen()
    //fun replaceScreenContent()
  }

}
