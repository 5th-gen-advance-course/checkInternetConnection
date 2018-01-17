package com.example.ratha.sweetalertdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ratha.sweetalertdemo.R
import com.example.ratha.sweetalertdemo.entity.Product
import kotlinx.android.synthetic.main.recycler_view_item_grid_layout.view.*

/**
 * Created by ratha on 1/17/2018.
 */
class ProductAdapter(var context: Context,var products: MutableList<Product>) :RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if(products!=null){
            val product= products.get(position)
            with(product){
                if(TextUtils.isEmpty(name)) holder!!.title.text=name
            }
            holder!!.image.setImageResource(R.drawable.mi_band_2)
        }
    }
    override fun getItemCount(): Int {
       return products.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
      val view=LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        lateinit var image: ImageView
        lateinit var title: TextView
        init {
            image=itemView.findViewById(R.id.image)
            title=itemView.findViewById(R.id.title)
        }
    }

}