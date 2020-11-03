package com.example.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.scrollview.feature.first.FirstFragment
import com.example.scrollview.feature.fourth.FourthFragment
import com.example.scrollview.feature.second.SecondFragment
import com.example.scrollview.feature.third.ThirdFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // attach main fragment
        val transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.frameMain, FirstFragment()).commit()

        // bottom navigation click event
        bnvMain.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    val transaction = supportFragmentManager.beginTransaction()

                    when(item.itemId) {
                        R.id.first -> {
                            transaction.replace(R.id.frameMain, FirstFragment()).commit()
                            return true
                        }
                        R.id.second -> {
                            transaction.replace(R.id.frameMain, SecondFragment()).commit()
                            return true
                        }
                        R.id.third -> {
                            transaction.replace(R.id.frameMain, ThirdFragment()).commit()
                            return true
                        }
                        else -> {
                            transaction.replace(R.id.frameMain, FourthFragment()).commit()
                            return true
                        }
                    }
                    return false
                }
            }
        )


    }
}