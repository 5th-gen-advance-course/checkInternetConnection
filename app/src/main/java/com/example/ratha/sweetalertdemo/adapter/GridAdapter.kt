package com.example.ratha.sweetalertdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.ratha.sweetalertdemo.R
import org.w3c.dom.Text

/**
 * Created by ratha on 1/12/2018.
 */
class GridAdapter(var context : Context,var menus: MutableList<String> ) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       var view : View?
        if (convertView==null){
            view =LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent,false)
        }else{
            view=convertView
        }
        val menuItem=view!!.findViewById<TextView>(R.id.menuItem)
        if(menus!=null){
            menuItem.text=this.menus.get(position)
        }
        return view!!
    }

    override fun getItem(position: Int): Any {
        return menus.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return menus.size
    }

    fun setMenuData(menus: MutableList<String>){
        this.menus=menus
        notifyDataSetChanged()
    }
}