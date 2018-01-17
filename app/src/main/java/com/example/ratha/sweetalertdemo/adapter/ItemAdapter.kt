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
import com.example.ratha.sweetalertdemo.entity.Item

/**
 * Created by ratha on 1/13/2018.
 */
class ItemAdapter(var context : Context, var list : MutableList<Item> ) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    lateinit var mItem : Item
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if(!list.isEmpty() || list!=null){
            val linear =this.list.get(position)
            if(TextUtils.isEmpty(linear.title)) holder!!.tvTitle.text=linear.title
            if(TextUtils.isEmpty(linear.desc)) holder!!.tvDesc.text=linear.desc
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.recycler_view_item_linear_layout,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        lateinit var tvTitle : TextView;
        lateinit var tvDesc: TextView;
        lateinit var btnDot : ImageView;
        init {
            tvTitle=itemView.findViewById(R.id.title)
            tvDesc=itemView.findViewById(R.id.desc)
            btnDot=itemView.findViewById(R.id.btnThreeDot)
        }
    }

    fun setItem(item : Item){
        this.mItem=item
        this.list.add(this.mItem)
        notifyItemInserted(this.list.size-1)
    }
    fun setItems(items: MutableList<Item>){
        this.list=items
        notifyDataSetChanged()
    }

}