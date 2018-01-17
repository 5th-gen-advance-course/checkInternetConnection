package com.example.ratha.sweetalertdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.ratha.sweetalertdemo.adapter.GridAdapter

class GridMenuActivity : AppCompatActivity() {
    lateinit var adapter:GridAdapter
    lateinit var gridView: GridView
    var menus = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_menu)

        setupGridView()

    }

    fun setupGridView(){
        gridView=findViewById(R.id.gridView)
        adapter= GridAdapter(this,this.menus)
        gridView.adapter=adapter
        gridView.setOnItemClickListener(object :AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext,""+menus.get(position),Toast.LENGTH_SHORT).show()
            }
        })
        setMenuData()
    }

    fun setMenuData(){
        this.menus.add("Balance")
        this.menus.add("Payment")
        this.menus.add("Transfer")
        this.menus.add("Motification")
        this.menus.add("Visual Card")
        this.adapter.setMenuData(this.menus)
    }

}
