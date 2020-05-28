package es.ulpgc.iumati.swagger.opendata.screens.paradataxi

import android.content.Intent
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import android.util.Log

import es.ulpgc.iumati.swagger.opendata.R

class ParadaTaxiRouter : ParadaTaxiContract.Router {

    var activity: WeakReference<FragmentActivity>? = null

    //TODO: poner tipo correcto para param de entrada
    override fun passDataToNextScreen(data: ParadaTaxiData) {
        Log.e(TAG, "passDataToNextScreen()")

        /*
        (activity?.get()?.application as AppMediator).let { mediator ->
          mediator.data = data
        }
        */
    }

    //TODO: poner tipo correcto para retornar
    override fun getDataFromPreviousScreen(): ParadaTaxiData? {
        Log.e(TAG, "getDataFromPreviousScreen()")

        var data: ParadaTaxiData? = null

        /*
        (activity?.get()?.application as AppMediator).let { mediator ->
            return mediator.data
        }
        */

        return data
    }

    //TODO: poner actividad de destino correcta
    override fun navigateToNextScreen() {
        Log.e(TAG, "navigateToNextScreen()")

        activity?.get()?.let { context ->
            val intent = Intent(context, ParadaTaxiActivity::class.java)
            context.startActivity(intent)
        }
    }


    companion object {
        const val TAG = "ParadaTaxiRouter"
    }
}
