package com.example.recyclerview.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.recyclerview.R
import com.example.recyclerview.feature.grid.GridFragment
import com.example.recyclerview.feature.linear.LinearFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // attach fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameMain, LinearFragment()).commit()

        bottomNaviMain.setOnNavigationItemSelectedListener(
                object : BottomNavigationView.OnNavigationItemSelectedListener {
                    override fun onNavigationItemSelected(item: MenuItem): Boolean {
                        when(item.itemId) {
                            R.id.linear -> {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.frameMain, LinearFragment()).commit()
                                return true
                            }
                            else -> {
                                supportFragmentManager.beginTransaction()
                                        .replace(R.id.frameMain, GridFragment()).commit()
                                return true
                            }
                        }
                        return false
                    }
                }
        )
    }
}
