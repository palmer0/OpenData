package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

object ParadasGuaguaScreen {

  fun configureActivity(view: ParadasGuaguaContract.View) {

    val activity = view as FragmentActivity

    val router = ParadasGuaguaRouter()
    router.activity = WeakReference(activity)

    val presenter = ParadasGuaguaPresenter()
    presenter.view = WeakReference(view)
    presenter.activity = WeakReference(activity)
    presenter.router = router

    presenter.state = ViewModelProviders
      .of(activity)
      .get(ParadasGuaguaState::class.java)

    val model = ParadasGuaguaModel(activity = WeakReference(activity))
    presenter.model = model

    view.presenter = presenter

  }

  /*
  fun configureFragment(view: ParadasGuaguaContract.View) {

    val fragment = view as Fragment

    val router = ParadasGuaguaRouter()
    router.fragment = WeakReference(fragment)

    val presenter = ParadasGuaguaPresenter()
    presenter.view = WeakReference(view)
    presenter.fragment = WeakReference(fragment)
    presenter.router = router

    presenter.state = ViewModelProviders
      .of(fragment)
      .get(ParadasGuaguaState::class.java)

    val model = ParadasGuaguaModel(fragment = WeakReference(fragment))
    presenter.model = model

    view.presenter = presenter

  }
  */
}
