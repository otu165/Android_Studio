package com.example.recyclerview.feature.grid

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class GridRvViewHolder (view : View) : RecyclerView.ViewHolder(view) {
    private val txt : TextView = view.findViewById(R.id.txtRvGridItem)

    fun bind(data : String) {
        txt.text = data
    }
}