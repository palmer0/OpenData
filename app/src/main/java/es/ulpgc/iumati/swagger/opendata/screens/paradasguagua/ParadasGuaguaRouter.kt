package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

class ParadasGuaguaRouter : ParadasGuaguaContract.Router {

    var activity: WeakReference<FragmentActivity>? = null

    override fun passDataToNextScreen(data: ParadasGuaguaData?) {
        Log.e(TAG, "passDataToNextScreen()")

        /*
        (activity?.get()?.application as AppMediator).let { mediator ->
          mediator.data = data
        }
        */
    }

    override fun getDataFromPreviousScreen(): ParadasGuaguaData? {
        Log.e(TAG, "getDataFromPreviousScreen()")

        var data: ParadasGuaguaData? = null


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
            val intent = Intent(context, ParadasGuaguaActivity::class.java)
            context.startActivity(intent)
        }
    }

    companion object {
        const val TAG = "ParadasGuaguaRouter"
    }
}
