package com.example.scrollview.feature.third

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollview.R

class ThirdFragRvVH(view : View) : RecyclerView.ViewHolder(view) {
    val text : TextView = view.findViewById(R.id.txtThirdFrag)

    fun bind(s : String) {
        text.text = s
    }
}