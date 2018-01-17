package com.example.ratha.sweetalertdemo.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ratha.sweetalertdemo.R
import com.example.ratha.sweetalertdemo.entity.Product
import com.example.ratha.sweetalertdemo.entity.ProductParent

/**
 * Created by ratha on 1/17/2018.
 */
class ParentProductAdapter(var context :Context ,var productParents : MutableList<ProductParent>)
    : RecyclerView.Adapter<ParentProductAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val productParent =productParents.get(position)
        initChildLayoutManager(holder!!.productRecyclerView,productParent.products)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(context).inflate(R.layout.child_recycler_view_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return productParents.size
    }

    fun initChildLayoutManager(rv : RecyclerView, products : MutableList<Product>){
       val layout=LinearLayoutManager(context)
        layout.orientation=LinearLayoutManager.HORIZONTAL
        rv.layoutManager=layout
        val adapter=ProductAdapter(context,products)
        rv.adapter=adapter
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var productRecyclerView: RecyclerView
        init {
            productRecyclerView=itemView.findViewById(R.id.childRecyclerView)
        }
    }
    fun setData(parentProducts : MutableList<ProductParent>){
        this.productParents=productParents
        notifyDataSetChanged()
    }
}