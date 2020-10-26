package com.example.gridview.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.gridview.R
import com.example.gridview.api.Service

class MainGvAdapter(private val context : Context) : BaseAdapter() {
    var data = Service.getMainGvData()

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
        val view : View = LayoutInflater.from(context).inflate(R.layout.gv_main_item, null)

        view.findViewById<TextView>(R.id.txtGvMainItemNum).text = data[p0].num.toString()
        view.findViewById<TextView>(R.id.txtGvMainItemDes).text = data[p0].description

        return view
    }
}