package es.ulpgc.iumati.swagger.opendata.screens.paradasguagua

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.ulpgc.iumati.swagger.opendata.R
import io.swagger.client.models.FeatureParadaGuagua


class ParadasGuaguaAdapter(
    val features: Array<FeatureParadaGuagua>
) : RecyclerView.Adapter<ParadasGuaguaAdapter.ViewHolder>() {

    var onClick: (View) -> Unit = {}

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView = view.findViewById(R.id.title_text_view) as TextView
        val bodyTextView = view.findViewById(R.id.body_text_view) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_paradas_guagua, parent, false)

        view.setOnClickListener { v ->
            this.onClick(v)
        }

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.let { vh ->

            val feature = features[position]
            vh.itemView.tag = feature

            feature.attributes?.let { attributes ->
                vh.titleTextView.text = attributes.PARADA
                vh.bodyTextView.text = attributes.LINEAS
            }
        }

    }


    override fun getItemCount(): Int {

        return this.features.size
    }


}