package com.example.mvvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mvvm.databinding.ActivityMainBinding

/**
 * <MVVM>
 * 1. Model - MainModel
 * 2. View - MainActivity
 * 3. ViewModel - MainViewModel
 */

class MainActivity : AppCompatActivity() {
    private val model by viewModels<MainViewModel>()  // ViewModel 객체
    private lateinit var binding: ActivityMainBinding  // DataBinding 객체

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this  // LiveData 를 사용하기 위함
        binding.model = model
    }
}