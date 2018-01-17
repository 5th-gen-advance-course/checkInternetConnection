package com.example.ratha.sweetalertdemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ratha.sweetalertdemo.R
import com.example.ratha.sweetalertdemo.entity.Post
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.timeline_item_layout.view.*

/**
 * Created by ratha on 1/13/2018.
 */
class InstagramAdapter(var context : Context ,var posts : MutableList<Post>) : RecyclerView.Adapter<InstagramAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if(posts!=null){
            val post =posts.get(position)
            if(post.profileName!=null) holder!!.tvProfileName.text=post.profileName
            if(post.profileImage!=0) holder!!.imageProfile.setImageResource(post.profileImage)
            if(post.imageContext!=0) holder!!.imageContent.setImageResource(post.imageContext)
            if(post.like!=null) holder!!.tvLike.text=post.like
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context) .inflate(
                R.layout.timeline_item_layout,parent,false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }


    class ViewHolder( itemView : View): RecyclerView.ViewHolder(itemView) {

        lateinit var btnLike: ImageView
        lateinit var btnComment: ImageView
        lateinit var imageContent : ImageView
        lateinit var imageProfile : CircleImageView
        lateinit var tvProfileName:TextView
        lateinit var tvBottomName:TextView
        lateinit var tvdesc:TextView
        lateinit var tvLike:TextView
        lateinit var tvTimePost:TextView

        init {
            btnComment = itemView.findViewById(R.id.btnComment)
            btnLike = itemView.findViewById(R.id.btnLike)
            imageProfile = itemView.findViewById(R.id.imageProfile)
            imageContent=itemView.findViewById(R.id.imageContent)
            tvProfileName = itemView.findViewById(R.id.profileName)
            tvBottomName = itemView.findViewById(R.id.tvbottomName)
            tvdesc= itemView.findViewById(R.id.tvDesc)
            tvLike = itemView.findViewById(R.id.tvLikeLabel)
            tvTimePost = itemView.findViewById(R.id.tvTimePost)
        }
    }
}