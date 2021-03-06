package es.ulpgc.iumati.swagger.opendata.screens.lineasguagua

import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentActivity
import es.ulpgc.iumati.swagger.opendata.app.AppMediator
import es.ulpgc.iumati.swagger.opendata.screens.lineaguagua.LineaGuaguaActivity
import es.ulpgc.iumati.swagger.opendata.screens.lineaguagua.LineaGuaguaData
import java.lang.ref.WeakReference

class LineasGuaguaRouter : LineasGuaguaContract.Router {

    var activity: WeakReference<FragmentActivity>? = null

    override fun passDataToNextScreen(data: LineaGuaguaData) {
        Log.e(TAG, "passDataToNextScreen()")

        (activity?.get()?.application as AppMediator).let { mediator ->
            mediator.lineaGuagua = data
        }
    }

    override fun getDataFromPreviousScreen(): LineasGuaguaData? {
        Log.e(TAG, "getDataFromPreviousScreen()")

        var data: LineasGuaguaData? = null

        /*
        (activity?.get()?.application as AppMediator).let { mediator ->
            return mediator.data
        }
        */

        return data
    }

    override fun navigateToNextScreen() {
        Log.e(TAG, "navigateToNextScreen()")

        activity?.get()?.let { context ->
            val intent = Intent(context, LineaGuaguaActivity::class.java)
            context.startActivity(intent)
        }
    }

    companion object {
        const val TAG = "LineasGuaguaRouter"
    }
}
