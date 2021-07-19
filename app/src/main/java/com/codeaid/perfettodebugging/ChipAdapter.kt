package com.codeaid.perfettodebugging

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip

class ChipAdapter(states : List<String>) : RecyclerView.Adapter<ChipAdapter.ChipViewHolder>() {

    private lateinit var ctx : Context
    private var listOfStates  = states

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.chip_layout, parent, false)
        return ChipViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfStates.count()
    }

    override fun onBindViewHolder(holder: ChipViewHolder, position: Int) {
        holder.chip.text = listOfStates[position]
    }

    class ChipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chip : Chip = itemView.findViewById<Chip>(R.id.text_unit)
    }
}
