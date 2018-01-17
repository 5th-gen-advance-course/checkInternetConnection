package com.example.ratha.sweetalertdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.ratha.sweetalertdemo.adapter.ItemGridAdapter
import com.example.ratha.sweetalertdemo.entity.ItemGrid

class RecyclerViewGridActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var itemGridAdapter: ItemGridAdapter
    var items= mutableListOf<ItemGrid>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_grid)

        recyclerView=findViewById(R.id.recyclerViewGrid)
        itemGridAdapter= ItemGridAdapter(this,items)
       /* recyclerView.layoutManager=GridLayoutManager(this,
                3,GridLayoutManager.VERTICAL,false)*/
        recyclerView.layoutManager=StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter=itemGridAdapter
        setData()
    }

    fun setData(){
        for(i in 0 .. 100){
            when(i){
                in 1..2 ->{
                    this.items.add(ItemGrid("火遍網絡",R.drawable.abc))
                }
                in 3..4 ->{
                    this.items.add(ItemGrid("火遍網絡",R.drawable.cl_solo))

                }
                in 6..44->{
                    this.items.add(ItemGrid("火遍網絡",R.drawable.maxresdefault))

                }
                else->{
                    this.items.add(ItemGrid("火遍網絡",R.drawable.abc))

                }
            }


        }
        this.itemGridAdapter.setItems(this.items)
    }
}
