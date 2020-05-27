package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.content.Intent
import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import android.util.Log

import es.ulpgc.iumati.swagger.opendata.R

class ParadasGuaguaRouter : ParadasGuaguaContract.Router {

  //var fragment: WeakReference<Fragment>? = null
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

        (fragment?.get()?.activity?.application as AppMediator).let { mediator ->
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

//  override fun navigateToNextScreen() {
//    Log.e(TAG, "navigateToNextScreen()")
//
//    fragment?.get()?.activity?.let { context ->
//      val intent = Intent(context, ParadasGuaguaActivity::class.java)
//      context.startActivity(intent)
//    }
//  }


//  override fun replaceScreenContent() {
//    Log.e(TAG, "replaceScreenContent()")
//
//    activity?.get()?.supportFragmentManager?.let { fm ->
//
//      activity?.get()?.runOnUiThread {
//        fm.beginTransaction()
//          .replace(R.id.container, ParadasGuaguaFragment())
//          .commitNow()
//      }
//    }
//  }

  /*
    fun determineNextScreenContent(position: Int): Fragment {
       // based on position decide what is next screen content

        when (position) {
           else -> {
             return ParadasGuaguaFragment()
           }
        }
    }

    fun navigateToNextScreen(position: Int) {
        val nextFragment = determineNextScreenContent(position)
        // Ask the activity to show the next fragment
        fragment?.get()?.activity?.let { context ->
          context.supportFragmentManager?.let { fm ->

            context.runOnUiThread {
              fm.beginTransaction()
                .replace(R.id.container, nextFragment)
                .commitNow()
            }
          }
        }

    }
    */

  companion object {
    const val TAG = "ParadasGuaguaRouter"
  }
}
