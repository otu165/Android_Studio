package com.example.mvp.ui

import com.example.mvp.util.MainModel

/***
 * <Presenter>
 * 1. Presenter 는 interface 에 의해 View 와 연결된다.
 * 2. Presenter 와 Model 연결
 * 3. (interface 호출을 통해) Presenter 와 View 가 연결된다.
 */

class AppPresenter(val appContract: AppContract) {  // interface 객체 가짐

    // Model 과 연결
    fun getAppFromModel() = MainModel(
        "Master Coding App",
        999990,
        4.7F
    )

    // View 갱신 (Model 로 부터 받은 데이터 넘겨줘야 함)
    fun getAppDetails() {
        appContract.getAppName(getAppFromModel().appName)
    }
}