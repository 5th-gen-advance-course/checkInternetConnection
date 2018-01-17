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
import com.example.ratha.sweetalertdemo.entity.ItemGrid


/**
 * Created by ratha on 1/13/2018.
 */
class ItemGridAdapter(var context : Context, var list : MutableList<ItemGrid> ) :
        RecyclerView.Adapter<ItemGridAdapter.ViewHolder>() {
    lateinit var mItem : ItemGrid
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if(!list.isEmpty() || list!=null) {
            val itemGird = this.list.get(position)
            if (TextUtils.isEmpty(itemGird.title)) holder!!.tvTitle.text = itemGird.title
            if (itemGird.image != 0) holder!!.image.setImageResource(itemGird.image)
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.recycler_view_item_grid_layout,parent,false)
        return ViewHolder(view)
    }



    fun setItem(item : ItemGrid){
        this.mItem=item
        this.list.add(this.mItem)
        notifyItemInserted(this.list.size-1)
    }
    fun setItems(items: MutableList<ItemGrid>){
        this.list=items
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        lateinit var tvTitle : TextView;
        lateinit var image: ImageView
        lateinit var btnDot : ImageView;
        init {
            tvTitle=itemView.findViewById(R.id.title)
            image=itemView.findViewById(R.id.image)
            btnDot=itemView.findViewById(R.id.btnThreeDot)
        }
    }

}



