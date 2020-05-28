package es.ulpgc.iumati.swagger.opendata.app

import android.app.Application
import es.ulpgc.iumati.swagger.opendata.screens.lineaguagua.LineaGuaguaData
import es.ulpgc.iumati.swagger.opendata.screens.paradataxi.ParadaTaxiData

class AppMediator : Application() {

    var lineaGuagua: LineaGuaguaData? = null
    var paradaTaxi: ParadaTaxiData? = null
}