package com.codeaid.perfettodebugging

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.os.Trace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.recyclerview.widget.RecyclerView.getChildMeasureSpec
import com.codeaid.perfettodebugging.datamodel.Country
import com.google.android.material.chip.Chip
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class ItemsAdapter(private val dataSet: List<Country>) : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    private lateinit var ctx : Context

    val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {

        ctx = parent.context
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return ItemsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        Trace.beginSection("Perf : OnBindViewHolder Optimised")

        holder.header.text = dataSet[position].country

        holder.chip.adapter = ChipAdapter(dataSet[position].states)
        holder.chip.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL,false)

        /*holder.chipHolder.removeAllViews()
        for(i in dataSet[position].states){
            var params = LinearLayout.LayoutParams(100.toPx,50.toPx)
            params.leftMargin = 2.toPx
            params.rightMargin = 2.toPx
            var textView  = Chip(ctx)
            textView.layoutParams = params
            textView.text = i
            holder.chipHolder.addView(textView)
        }*/
        Trace.endSection()
    }

    class ItemsViewHolder(itemView: View) : ViewHolder(itemView) {
        val header : TextView = itemView.findViewById(R.id.header)
        //val chipHolder : LinearLayout = itemView.findViewById(R.id.chip_holder)
        val chip : RecyclerView = itemView.findViewById(R.id.tags)
    }
}


