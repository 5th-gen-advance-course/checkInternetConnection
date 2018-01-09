package com.example.ratha.sweetalertdemo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.ratha.sweetalertdemo.app.App
import com.example.ratha.sweetalertdemo.util.broadcastreceiver.ConnectivityReceiver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener
    ,ConnectivityReceiver.ConnectivityReceiverListener{


    lateinit var btnBasic : Button
    lateinit var btnManualChecked: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBasic=findViewById(R.id.btnBasic)
        btnManualChecked=findViewById<Button>(R.id.btnCheckNetworkConnection)

        btnBasic.setOnClickListener(this)
        btnManualChecked.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnBasic->{

            }
            R.id.btnCheckNetworkConnection->{
                checkInternetConnection();
            }

        }
    }

    fun checkInternetConnection(){
       val isConnected=ConnectivityReceiver.isConnect()
        showSnack(isConnected)
    }

    fun showSnack(isConnected :Boolean){
        var message: String=""
        var color=Color.parseColor("#FFFFFF")
        if(isConnected){
            message="Good! Connected to Internet"
            color=Color.WHITE
        }
        else{
            message="Sorry! Not connected to internet"
            color=Color.RED
        }
        Snackbar.make(btnCheckNetworkConnection,message,Snackbar.LENGTH_LONG).show()

    }
    override fun onNetworkConnectionChanged(isConnect: Boolean) {
        showSnack(isConnect)
    }

    override fun onResume() {
        super.onResume()
        App.getInstance().setConnectivityListener(this)
    }


}
