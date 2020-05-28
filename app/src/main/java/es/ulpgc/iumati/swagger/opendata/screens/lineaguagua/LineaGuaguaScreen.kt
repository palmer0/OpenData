package es.ulpgc.iumati.swagger.opendata.screens.lineaguagua

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import java.lang.ref.WeakReference

object LineaGuaguaScreen {

    fun configure(view: LineaGuaguaContract.View) {

        val activity = view as FragmentActivity

        val router = LineaGuaguaRouter()
        router.activity = WeakReference(activity)

        val presenter = LineaGuaguaPresenter()
        presenter.view = WeakReference(view)
        presenter.activity = WeakReference(activity)
        presenter.router = router

        presenter.state = ViewModelProviders
            .of(activity)
            .get(LineaGuaguaState::class.java)

        val model = LineaGuaguaModel(activity = WeakReference(activity))
        presenter.model = model

        view.presenter = presenter

    }

}
