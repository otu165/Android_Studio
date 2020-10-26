package com.example.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class MainVpAdapter (private val context : Context) : PagerAdapter() {
    val data = listOf<String>(
        "첫 번째",
        "두 번째",
        "세 번째",
        "네 번째"
    )

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view : View = layoutInflater.inflate(R.layout.vp_main_item, null)

        view.findViewById<TextView>(R.id.txtVpMainItem).text = data[position]

        val viewPager = container as ViewPager
        viewPager.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View

        viewPager.removeView(view)
    }

}