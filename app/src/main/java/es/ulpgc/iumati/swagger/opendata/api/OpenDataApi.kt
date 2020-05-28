package es.ulpgc.iumati.swagger.opendata.api

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.google.gson.Gson
import io.swagger.client.models.*

class OpenDataApi {

    private val baseUrl =
        "https://services.arcgis.com/hkQNLKNeDVYBjvFE/arcgis/rest/services"

    private fun getRequest(
        url: String, success: (String) -> Unit, failure: (FuelError) -> Unit
    ) {


        Fuel.get(url).responseString { request, response, result ->

            val (data, error) = result

            if (error != null) {
                Log.v("Error", error.toString())
                failure(error)
            } else {
                val onSuccess = data ?: return@responseString
                success(onSuccess)

            }

        }

    }

    fun fetchParadasTaxi(
        success: (Array<FeatureParadaTaxi>) -> Unit,
        failure: (FuelError) -> Unit
    ) {

        val url =
            baseUrl + "/Transportes/FeatureServer/0/query?where=1%3D1&outFields=OBJECTID,Nombre,Municipio,Telefono,Direccion,Foto&outSR=4326&f=json"

        getRequest(url, success = { response ->

            val data = Gson().fromJson(response, ParadasTaxi::class.java)

            data.features?.let { features ->

                success(features)
            }

        }, failure = { error ->
            failure(error)
        })
    }


    fun fetchParadasGuagua(
        success: (Array<FeatureParadaGuagua>) -> Unit,
        failure: (FuelError) -> Unit
    ) {

        val url =
            baseUrl + "/Transportes/FeatureServer/1/query?where=1%3D1&outFields=LATITUD,LONGITUD,PARADA,LINEAS,OBJECTID&outSR=4326&f=json"

        getRequest(url, success = { response ->

            val data = Gson().fromJson(response, ParadasGuagua::class.java)

            data.features?.let { features ->

                success(features)
            }

        }, failure = { error ->
            failure(error)
        })
    }

    fun fetchLineasGuagua(
        success: (Array<FeatureLineaGuagua>) -> Unit,
        failure: (FuelError) -> Unit
    ) {

        val url =
            baseUrl + "/Transportes/FeatureServer/2/query?where=1%3D1&outFields=*&outSR=4326&f=json"

        getRequest(url, success = { response ->

            val data = Gson().fromJson(response, LineasGuagua::class.java)

            data.features?.let { features ->

                success(features)
            }

        }, failure = { error ->
            failure(error)
        })
    }

}