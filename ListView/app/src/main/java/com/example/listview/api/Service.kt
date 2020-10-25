package com.example.listview.api

import com.example.listview.data.MainLvData

object Service {
    fun getMainLvData() : List<MainLvData> {
        val list = mutableListOf<MainLvData>()

        for (i in 0 .. 20) {
            list.add(MainLvData("${i+1}번째 제목", "${i+1}번째 제목에 대한 설명란"))
        }

        return list
    }
}