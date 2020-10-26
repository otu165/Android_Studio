package com.example.gridview.api

import com.example.gridview.data.MainGvData

object Service {
    fun getMainGvData() : List<MainGvData> {
        val list = mutableListOf<MainGvData>()

        for(i in 1..18) {
            list.add(MainGvData(i, "image description area\nfor number $i"))
        }

        return list
    }
}