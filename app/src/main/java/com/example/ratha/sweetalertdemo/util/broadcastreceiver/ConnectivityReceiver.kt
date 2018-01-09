package com.example.ratha.sweetalertdemo.util.broadcastreceiver


import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.example.ratha.sweetalertdemo.app.App
import com.example.ratha.sweetalertdemo.util.broadcastreceiver.ConnectivityReceiver.ConnectivityReceiverListener



/**
 * Created by ratha on 1/10/2018.
 */
class ConnectivityReceiver : BroadcastReceiver(){

        companion object {
            var connectivityReceiverListener: ConnectivityReceiverListener? = null
            @SuppressLint("MissingPermission")
            fun isConnect(): Boolean {
                val cm = App.getInstance().applicationContext
                        .getSystemService(Context.CONNECTIVITY_SERVICE)
                        as ConnectivityManager
                val activeNetwork=cm.activeNetworkInfo


                return activeNetwork!=null && activeNetwork.isConnectedOrConnecting

            }
        }

    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context?, intent: Intent?) {
        val cm= context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork =cm.activeNetworkInfo

        val isConnected= activeNetwork!=null && activeNetwork.isConnectedOrConnecting
        if (connectivityReceiverListener!=null)
            connectivityReceiverListener!!.onNetworkConnectionChanged(isConnected)
    }

    interface ConnectivityReceiverListener{
        open fun onNetworkConnectionChanged(isConnect : Boolean);
    }
}