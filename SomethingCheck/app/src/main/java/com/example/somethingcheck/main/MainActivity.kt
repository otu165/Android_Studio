package com.example.somethingcheck.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.somethingcheck.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_main_item.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // compose ViewPager + TabLayout
        val vpAdapter = MainVpAdapter(supportFragmentManager)
        vpMain.adapter = vpAdapter
        tabMain.setupWithViewPager(vpMain)

        tabMain.getTabAt(0)?.customView = getCustomTabView("CHECKBOX")
        tabMain.getTabAt(1)?.customView = getCustomTabView("RADIOBUTTON")
        tabMain.getTabAt(2)?.customView = getCustomTabView("SPINNER")
        tabMain.getTabAt(3)?.customView = getCustomTabView("TOGGLE")
        tabMain.getTabAt(4)?.customView = getCustomTabView("PICKER")
    }

    private fun getCustomTabView(name : String) : View {
        val view: View = LayoutInflater.from(this).inflate(R.layout.tab_main_item, null)

        view.tabMainItem.text = name

        return view
    }
}