package es.ulpgc.iumati.swagger.opendata.screens.paradastaxi

import android.content.Intent
import java.lang.ref.WeakReference
import androidx.fragment.app.FragmentActivity
import android.util.Log

import es.ulpgc.iumati.swagger.opendata.app.AppMediator
import es.ulpgc.iumati.swagger.opendata.screens.paradataxi.ParadaTaxiActivity
import es.ulpgc.iumati.swagger.opendata.screens.paradataxi.ParadaTaxiData

class ParadasTaxiRouter : ParadasTaxiContract.Router {

    var activity: WeakReference<FragmentActivity>? = null

    override fun passDataToNextScreen(data: ParadaTaxiData) {
        Log.e(TAG, "passDataToNextScreen()")

        (activity?.get()?.application as AppMediator).let { mediator ->
          mediator.paradaTaxi = data
        }
    }

    //TODO: poner tipo correcto para retornar
    override fun getDataFromPreviousScreen(): ParadasTaxiData? {
        Log.e(TAG, "getDataFromPreviousScreen()")

        var data: ParadasTaxiData? = null

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
            val intent = Intent(context, ParadaTaxiActivity::class.java)
            context.startActivity(intent)
        }
    }


    companion object {
        const val TAG = "ParadasTaxiRouter"
    }
}
