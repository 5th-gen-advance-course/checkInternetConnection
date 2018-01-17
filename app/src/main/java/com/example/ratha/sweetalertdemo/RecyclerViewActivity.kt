package com.example.ratha.sweetalertdemo

import android.content.ClipData
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import com.balysv.materialripple.MaterialRippleLayout
import com.example.ratha.sweetalertdemo.adapter.ItemAdapter
import com.example.ratha.sweetalertdemo.entity.Item
import jp.wasabeef.recyclerview.adapters.*
import jp.wasabeef.recyclerview.animators.*

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter
    var items = mutableListOf<Item>()
    lateinit var  recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        itemAdapter= ItemAdapter(this,this.items)
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        val alphaIn =AlphaInAnimationAdapter(itemAdapter)
        alphaIn.setDuration(500)

        /*val fadeInDown=FadeInDownAnimator()
        fadeInDown.addDuration=500*/
        //recyclerView.adapter=ScaleInAnimationAdapter(alphaIn)

        //item animation
        val slideIn=SlideInLeftAnimator()
        recyclerView.itemAnimator=slideIn
        //slid bottom

        val slideBottom =SlideInBottomAnimationAdapter(itemAdapter)
        slideBottom.setDuration(1000)
        recyclerView.adapter=slideBottom

        /*val slideRight=SlideInRightAnimationAdapter(itemAdapter)
        slideRight.setDuration(1000)
        recyclerView.adapter=slideRight*/

        //scale

        setItems()
    }

    fun setItems(){
        for(i in 0 .. 100){
            this.items.add(Item("Suspect arrested for alleged murder of UPenn student",
                    "Samuel Woodward, a high school classmate of Bernstein's and also 19-years-old, was brought into custody this afternoon during a traffic stop and charged with suspicion of homicide in the death of the teenager."))
        }

        itemAdapter.setItems(this.items)
    }

}
