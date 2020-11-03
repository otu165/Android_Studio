package com.example.scrollview.feature.third

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollview.R
import com.example.scrollview.api.Service

class ThirdFragRvAdapter(private val context : Context) : RecyclerView.Adapter<ThirdFragRvVH>() {
    var data = Service.getThirdFragRvData()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThirdFragRvVH {
        val view : View = LayoutInflater.from(context).inflate(R.layout.rv_thrid_frag_item, null)
        return ThirdFragRvVH(view)
    }

    override fun onBindViewHolder(holder: ThirdFragRvVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}