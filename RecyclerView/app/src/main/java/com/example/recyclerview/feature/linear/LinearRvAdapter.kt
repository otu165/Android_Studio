package com.example.recyclerview.feature.linear

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.api.Service

class LinearRvAdapter(private val context : Context) : RecyclerView.Adapter<LinearRvViewHolder>() {
    var data = Service.getLinearData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinearRvViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.rv_linear_item, null)
        return LinearRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: LinearRvViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}