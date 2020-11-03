package com.example.scrollview.api

object Service {
    fun getThirdFragRvData() : List<String> {
        var list = mutableListOf<String>()

        for(i in 0..19) {
            list.add("${i+1}번째")
        }

        return list
    }

    fun getFourthRvData() : List<String> {
        var list = mutableListOf<String>()

        for (i in 0..19) {
            list.add("${i+1}")
        }

        return list
    }
}