package es.ulpgc.iumati.swagger.opendata.screens.paradataxi

import android.util.Log
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import es.ulpgc.iumati.swagger.opendata.R

class ParadaTaxiActivity : AppCompatActivity(), ParadaTaxiContract.View {

    override lateinit var presenter: ParadaTaxiContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parada_taxi)

        supportActionBar?.title = getString(R.string.title_parada_taxi)


        // Do the setup
        ParadaTaxiScreen.configure(this)

        // Call the presenter to fetch the data
        presenter.fetchLiveData().observe(this, Observer { viewModel ->
            Log.e(TAG, "fetchLiveData()")


            val titleTextView = findViewById(R.id.title_text_view) as TextView
            val bodyTextView = findViewById(R.id.body_text_view) as TextView

            val feature = viewModel.feature

            feature.attributes?.let { attributes ->
                titleTextView.text = attributes.Nombre
                bodyTextView.text = attributes.Municipio
            }
        })

    }

    companion object {
        const val TAG = "ParadaTaxiActivity"
    }
}
