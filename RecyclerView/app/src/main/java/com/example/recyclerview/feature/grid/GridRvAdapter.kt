package com.example.recyclerview.feature.grid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.api.Service

class GridRvAdapter (private val context : Context) : RecyclerView.Adapter<GridRvViewHolder>() {
    var data = Service.getGridData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridRvViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.rv_grid_item, null)
        return GridRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridRvViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}