package com.example.ratha.sweetalertdemo.app

import android.app.Application
import com.example.ratha.sweetalertdemo.util.broadcastreceiver.ConnectivityReceiver

/**
 * Created by ratha on 1/10/2018.
 */
class App : Application() {
    companion object {
        lateinit var app : App
        fun getInstance(): App {
            synchronized(this){
                return app
             }
        }
    }
    override fun onCreate() {
        super.onCreate()
        app=this
    }

    fun setConnectivityListener(listener: ConnectivityReceiver.ConnectivityReceiverListener){
        ConnectivityReceiver.connectivityReceiverListener=listener
    }
}