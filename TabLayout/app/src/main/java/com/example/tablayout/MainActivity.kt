package com.example.tablayout

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.tablayout.fragment.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFunction()
    }

    private fun mainFunction() {
        // 1. ViewPager
        val vpAdapter = MainVpAdapter(supportFragmentManager)
        addFragment(vpAdapter)

        vpMain.adapter = vpAdapter

        // 2. TabLayout
        tabMain.setupWithViewPager(vpMain)
        tabMain.getTabAt(0)?.customView = getTabCustomView(TabData(1, R.drawable.ic_baseline_filter_1_24))
        tabMain.getTabAt(1)?.customView = getTabCustomView(TabData(2, R.drawable.ic_baseline_filter_2_24))
        tabMain.getTabAt(2)?.customView = getTabCustomView(TabData(3, R.drawable.ic_baseline_filter_3_24))
    }

    private fun addFragment(adapter : MainVpAdapter) {
        adapter.addFragment(MainFragment())

        val frag2 = MainFragment()
        frag2.s = "2"
        adapter.addFragment(frag2)

        val frag3 = MainFragment()
        frag3.s = "3"
        adapter.addFragment(frag3)
    }

    private fun getTabCustomView(data : TabData) : View {
        val view: View = LayoutInflater.from(this).inflate(R.layout.tab_main_item, null)

        view.findViewById<TextView>(R.id.txtTabMainItem).text = data.num.toString()
        view.findViewById<ImageView>(R.id.imgTabMainItem).setImageResource(data.image)

        return view
    }

    data class TabData(
        val num : Int,
        val image : Int
    )
}