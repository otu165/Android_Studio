package com.example.mvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.mvp.R

/**
 * <MVP>
 * 1. View : Activity (TextView & Button)
 * 2. Model : MainModel
 * 3. Presenter : AppPresenter
 */

class MainActivity : AppCompatActivity(), AppContract {
    private lateinit var presenter: AppPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // presenter 초기화
        presenter = AppPresenter(this)
    }

    fun displayAppInText(view: View) {
        // DB 로 부터 데이터를 가져오기 위해 Presenter 를 호출한다.
        // (Activity 와 Model 사이의 연결은 없다. Activity 는 UI 만을 다룬다.)
        presenter.getAppDetails()
    }

    override fun getAppName(name: String) {
        findViewById<TextView>(R.id.txt_main).text = name
    }
}