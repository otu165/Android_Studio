package com.example.recyclerview.feature.linear

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.api.Service

class LinearRvViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    private val txtTitle : TextView = view.findViewById(R.id.txtRvLinearItem)
    private val txtDescription : TextView = view.findViewById(R.id.txtRvLinearItem2)

    fun bind(data : Service.LinearData) {
        txtTitle.text = data.title
        txtDescription.text = data.description
    }
}