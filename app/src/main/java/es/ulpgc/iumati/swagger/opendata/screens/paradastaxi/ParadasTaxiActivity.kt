package es.ulpgc.iumati.swagger.opendata.screens.paradastaxi

import android.util.Log
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import es.ulpgc.iumati.swagger.opendata.R
import io.swagger.client.models.FeatureLineaGuagua
import io.swagger.client.models.FeatureParadaTaxi

class ParadasTaxiActivity : AppCompatActivity(), ParadasTaxiContract.View {

    override lateinit var presenter: ParadasTaxiContract.Presenter

    lateinit var recyclerView: RecyclerView
    lateinit var recycler: RecyclerView.Adapter<ParadasTaxiAdapter.ViewHolder>
    lateinit var recyclerLayoutManager: RecyclerView.LayoutManager
    var adapter: ParadasTaxiAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paradas_taxi)

        supportActionBar?.title = getString(R.string.title_paradas_taxi)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = recyclerLayoutManager

        // Do the setup
        ParadasTaxiScreen.configure(this)

        // Call the presenter to fetch the data
        presenter.fetchLiveData().observe(this, Observer { viewModel ->
            Log.e(TAG, "fetchLiveData()")

            adapter = ParadasTaxiAdapter(viewModel.features)
            recycler = adapter!!
            recyclerView.adapter = recycler
            recycler.notifyDataSetChanged()
            adapter?.onClick = { view ->
                val feature = view.tag as FeatureParadaTaxi
                presenter.navigateToNextScreen(feature);
            }

        })

    }

    companion object {
        const val TAG = "ParadasTaxiActivity"
    }
}
