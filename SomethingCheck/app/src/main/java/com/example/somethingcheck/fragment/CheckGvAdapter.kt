package com.example.somethingcheck.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.somethingcheck.R
import kotlinx.android.synthetic.main.cb_frag_item.view.*

class CheckGvAdapter(private val context : Context) : BaseAdapter() {
    val data = listOf<String>(
        "빨간색", "주황색", "노란색",
        "초록색", "파란색", "남색",
        "보라색", "흰색", "검정색"
    )

    val color = mutableMapOf(
        "빨간색" to false,
        "주황색" to false,
        "노란색" to false,
        "초록색" to false,
        "파란색" to false,
        "남색" to false,
        "보라색" to false,
        "흰색" to false,
        "검정색" to false,
    )

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.cb_frag_item, null)
        view.cbFragItem.text = data[p0]

        view.cbFragItem.setOnClickListener {
            setColorList(view.cbFragItem.text.toString())
        }

        return view
    }

    private fun setColorList(key : String) {
        color[key] = !color[key]!!
    }

    fun getColorList() : Map<String, Boolean> {
        return color
    }
}