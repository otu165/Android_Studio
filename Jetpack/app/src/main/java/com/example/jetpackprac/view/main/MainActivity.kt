package com.example.jetpackprac.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackprac.R
import com.example.jetpackprac.databinding.ActivityMainBinding
import com.example.jetpackprac.util.MainRvAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.measureNanoTime

/**
 *
 * 1. TextView Ver
 *
 * 2. Recycler Ver
 *  -> 데이터 삭제 + update 가능하게 하기
 *
 * = (공통) Room + LiveData + ViewModel + DataBinding
 *
 */

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels() // activity-ktx 로 ViewModel 객체 생성

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this // LiveData 사용을 위해서 설정해주는 것
        binding.viewModel = mainViewModel // viewModel 을 넣어줌으로써 xml 에서 viewModel 을 가지고 데이터 바인딩을 사용할 수 있게됨

        // recycler view setting
        val rvAdapter = MainRvAdapter(this, mainViewModel)
        rv_main.adapter = rvAdapter
        rv_main.layoutManager = LinearLayoutManager(this)

        // Observer 를 사용함으로써 DataBinding 의 필요성이 낮아짐, 한번에 모든 library 를 전부 사용하는게 좋지만은 않음을 명시
        // observer(옵저버) 설정
        mainViewModel.textList.observe(this, Observer {
            // Update UI
            rvAdapter.updateData(it)
        })

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}