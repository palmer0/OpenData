package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import java.lang.ref.WeakReference

object ParadasGuaguaScreen {

    fun configure(view: ParadasGuaguaContract.View) {

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

}
