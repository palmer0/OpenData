package es.ulpgc.iumati.swagger.opendata.screens.lineaguagua

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import es.ulpgc.iumati.swagger.opendata.R

class LineaGuaguaActivity : AppCompatActivity(), LineaGuaguaContract.View {

    override lateinit var presenter: LineaGuaguaContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linea_guagua)

        supportActionBar?.title = getString(R.string.title_linea_guagua)


        // Do the setup
        LineaGuaguaScreen.configure(this)

        // Call the presenter to fetch the data
        presenter.fetchLiveData().observe(this, Observer { viewModel ->
            Log.e(TAG, "fetchLiveData()")

            val titleTextView = findViewById(R.id.title_text_view) as TextView
            val bodyTextView = findViewById(R.id.body_text_view) as TextView

            val feature = viewModel.feature

            feature.attributes?.let { attributes ->
                titleTextView.text = attributes.Linea.toString()
                bodyTextView.text = attributes.Recorrido
            }
        })

    }

    companion object {
        const val TAG = "LineaGuaguaActivity"
    }
}
