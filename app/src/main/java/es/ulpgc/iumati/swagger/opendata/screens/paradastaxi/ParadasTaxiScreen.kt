package es.ulpgc.iumati.swagger.opendata.screens.paradastaxi

import java.lang.ref.WeakReference
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders

object ParadasTaxiScreen {

    fun configure(view: ParadasTaxiContract.View) {

        val activity = view as FragmentActivity

        val router = ParadasTaxiRouter()
        router.activity = WeakReference(activity)

        val presenter = ParadasTaxiPresenter()
        presenter.view = WeakReference(view)
        presenter.activity = WeakReference(activity)
        presenter.router = router

        presenter.state = ViewModelProviders
            .of(activity)
            .get(ParadasTaxiState::class.java)

        val model = ParadasTaxiModel(activity = WeakReference(activity))
        presenter.model = model

        view.presenter = presenter

    }

}
