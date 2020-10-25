package com.example.listview.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.listview.R
import com.example.listview.api.Service

class MainLvAdapter(private val context : Context) : BaseAdapter() {
    var data = Service.getMainLvData()

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.lv_main_item, null)

        view.findViewById<TextView>(R.id.txtLvMainItem1).text = data[position].title
        view.findViewById<TextView>(R.id.txtLvMainItem2).text = data[position].title

        return view
    }

}