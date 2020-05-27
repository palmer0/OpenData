package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParadasGuaguaState : ViewModel() {

  var data: ParadasGuaguaData? = null

  /*
    private val liveData = MutableLiveData<ParadasGuaguaData>()

    fun setData(data: ParadasGuaguaData?) {
      liveData.value = data
    }

    fun getData(): ParadasGuaguaData? {
      return liveData.value
    }

    fun getLiveData(): LiveData<ParadasGuaguaData> {
        return liveData
    }
    */
}
