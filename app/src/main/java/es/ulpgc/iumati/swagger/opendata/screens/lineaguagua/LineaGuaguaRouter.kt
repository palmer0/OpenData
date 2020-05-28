package es.ulpgc.iumati.swagger.opendata.screens.lineaguagua

import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentActivity
import java.lang.ref.WeakReference

class LineaGuaguaRouter : LineaGuaguaContract.Router {

    var activity: WeakReference<FragmentActivity>? = null

    override fun passDataToNextScreen(data: LineaGuaguaData?) {
        Log.e(TAG, "passDataToNextScreen()")

        /*
        (activity?.get()?.application as AppMediator).let { mediator ->
          mediator.data = data
        }
        */
    }

    override fun getDataFromPreviousScreen(): LineaGuaguaData? {
        Log.e(TAG, "getDataFromPreviousScreen()")

        var data: LineaGuaguaData? = null

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
        const val TAG = "LineaGuaguaRouter"
    }
}
