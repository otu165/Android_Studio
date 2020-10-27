package com.example.bottomnavi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // attach FirstFragment
        supportFragmentManager.beginTransaction().add(R.id.frameMain, FirstFragment()).commit()

        // navigation select listener
        bottomNavi.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId) {
                        R.id.first -> {
                            supportFragmentManager.beginTransaction().replace(R.id.frameMain, FirstFragment()).commit()
                            return true
                        }
                        R.id.second -> {
                            supportFragmentManager.beginTransaction().replace(R.id.frameMain, SecondFragment()).commit()
                            return true
                        }
                        R.id.third -> {
                            supportFragmentManager.beginTransaction().replace(R.id.frameMain, ThirdFragment()).commit()
                            return true
                        }
                        R.id.fourth -> {
                            supportFragmentManager.beginTransaction().replace(R.id.frameMain, FourthFragment()).commit()
                            return true
                        }
                        else -> {
                            supportFragmentManager.beginTransaction().replace(R.id.frameMain, FifthFragment()).commit()
                            return true
                        }
                    }
                    return false
                }
            }
        )
    }
}