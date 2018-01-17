package com.example.ratha.sweetalertdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ratha.sweetalertdemo.adapter.ParentProductAdapter
import com.example.ratha.sweetalertdemo.entity.Product
import com.example.ratha.sweetalertdemo.entity.ProductParent

class NestedActivity : AppCompatActivity() {

    var products = mutableListOf<Product>()
    var parentProducts = mutableListOf<ProductParent>()
    lateinit var parentRecyclerView : RecyclerView
    lateinit var parentAdapter : ParentProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)

        parentAdapter= ParentProductAdapter(this,parentProducts)
        parentRecyclerView=findViewById(R.id.parentRecyclerView)
        parentRecyclerView.layoutManager=LinearLayoutManager(this)
        parentRecyclerView.adapter=parentAdapter

        setData();
    }

    fun setData(){
        for(i in 0..10){
            for(j in 0..10){
                products.add(Product("MI Band "+i))
            }
            parentProducts.add(ProductParent(this.products))
        }
        parentAdapter.setData(parentProducts)
    }
}
