package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.util.Log
import android.os.Bundle
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

    /*
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ParadasGuaguaFragment())
                .commitNow()
        }

        return
        */

    recyclerView = findViewById(R.id.recycler_view)
    recyclerLayoutManager = LinearLayoutManager(applicationContext)
    recyclerView.layoutManager = recyclerLayoutManager

    // Do the setup
    ParadasGuaguaScreen.configureActivity(this)

    // Call the presenter to fetch the data
    presenter.fetchLiveData().observe(this, Observer { viewModel ->
        Log.e(TAG, "fetchLiveData()")

        /*
        viewModel?.text.let { text ->
          Log.e(TAG, "text = $text")
        }
        */

        this.adapter = ParadasGuaguaAdapter(viewModel.features)
        //this.dataAdapter = FeaturesParadaAdapter(features)
        recycler = adapter!!
        recyclerView.adapter = recycler
        recycler.notifyDataSetChanged()
        adapter?.onClick = { view ->

        }


      })

  }

  /*
  override fun onResume() {
    super.onResume()

    //return

    // Call the presenter to fetch the data
    presenter.fetchData()
  }
  */

  /*
  override fun displayData(viewModel: ParadasGuaguaViewModel) {
    Log.e(TAG, "displayData()")

    // Deal with the data, update the states, ui etc..
    viewModel.text.let { text ->
      Log.e(TAG, "text = $text")
    }
  }
  */

  companion object {
    const val TAG = "ParadasGuaguaActivity"
  }
}
