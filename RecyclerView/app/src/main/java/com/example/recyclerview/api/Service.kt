package com.example.recyclerview.api

object Service {

    data class LinearData (
            val title : String,
            val description : String
    )

    fun getLinearData() : List<LinearData> {
        val list = mutableListOf<LinearData>()

        for (i in 1..12) {
            list.add(LinearData("$i 번째", "$i 번째 리스트입니다."))
        }

        return list
    }

    fun getGridData() : List<String> {
        val list = mutableListOf<String>()

        for (i in 1..20) {
            list.add("$i 번째")
        }

        return list
    }
}