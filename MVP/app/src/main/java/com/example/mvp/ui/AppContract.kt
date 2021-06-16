package com.example.mvp.ui

/**
 * Presenter <--> View 사이의 연결을 담당한다.
 *
 * interface 의 추상 메서드는 activity 에서 구현되며, View 를 갱신한다.
 */
interface AppContract {
    fun getAppName(name: String)
}