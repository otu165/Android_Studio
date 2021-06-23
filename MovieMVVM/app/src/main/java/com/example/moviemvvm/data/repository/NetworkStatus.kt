package com.example.moviemvvm.data.repository

// @info 네트워크 연결 상태
class NetworkStatus(val status: Status, val msg: String) {

    companion object {
        val LOADED = NetworkStatus(Status.SUCCESS, "Success")
        val LOADING = NetworkStatus(Status.RUNNING, "Running")
        val ERROR = NetworkStatus(Status.FAILED, "Failed")
    }
}

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}