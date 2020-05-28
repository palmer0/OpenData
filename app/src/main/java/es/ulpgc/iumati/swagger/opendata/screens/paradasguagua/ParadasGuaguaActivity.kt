package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.ulpgc.iumati.swagger.opendata.R

class ParadasGuaguaActivity : AppCompatActivity(), ParadasGuaguaContract.View {

    override lateinit var presenter: ParadasGuaguaContract.Presenter

    lateinit var recyclerView: RecyclerView
    lateinit var recycler: RecyclerView.Adapter<ParadasGuaguaAdapter.ViewHolder>
    lateinit var recyclerLayoutManager: RecyclerView.LayoutManager
    var adapter: ParadasGuaguaAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paradas_guagua)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = recyclerLayoutManager

        // Do the setup
        ParadasGuaguaScreen.configure(this)

        // Call the presenter to fetch the data
        presenter.fetchLiveData().observe(this, Observer { viewModel ->
            Log.e(TAG, "fetchLiveData()")

            this.adapter = ParadasGuaguaAdapter(viewModel.features)
            recycler = adapter!!
            recyclerView.adapter = recycler
            recycler.notifyDataSetChanged()
            adapter?.onClick = { view ->

            }
        })

    }


    companion object {
        const val TAG = "ParadasGuaguaActivity"
    }
}
