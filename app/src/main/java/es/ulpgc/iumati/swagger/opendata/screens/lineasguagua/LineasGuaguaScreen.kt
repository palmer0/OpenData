package es.ulpgc.iumati.swagger.opendata.screens.lineasguagua

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import java.lang.ref.WeakReference

object LineasGuaguaScreen {

    fun configure(view: LineasGuaguaContract.View) {

        val activity = view as FragmentActivity

        val router = LineasGuaguaRouter()
        router.activity = WeakReference(activity)

        val presenter = LineasGuaguaPresenter()
        presenter.view = WeakReference(view)
        presenter.activity = WeakReference(activity)
        presenter.router = router

        presenter.state = ViewModelProviders
            .of(activity)
            .get(LineasGuaguaState::class.java)

        val model = LineasGuaguaModel(activity = WeakReference(activity))
        presenter.model = model

        view.presenter = presenter

    }

}
