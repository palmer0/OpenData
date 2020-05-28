package es.ulpgc.iumati.swagger.opendata.screens.paradataxi

import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

object ParadaTaxiScreen {

    fun configure(view: ParadaTaxiContract.View) {

        val activity = view as FragmentActivity

        val router = ParadaTaxiRouter()
        router.activity = WeakReference(activity)

        val presenter = ParadaTaxiPresenter()
        presenter.view = WeakReference(view)
        presenter.activity = WeakReference(activity)
        presenter.router = router

        presenter.state = ViewModelProviders
            .of(activity)
            .get(ParadaTaxiState::class.java)

        val model = ParadaTaxiModel(activity = WeakReference(activity))
        presenter.model = model

        view.presenter = presenter

    }

}
