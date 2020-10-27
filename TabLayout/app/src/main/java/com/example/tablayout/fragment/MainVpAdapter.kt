package com.example.tablayout.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainVpAdapter (fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    val data = mutableListOf<Fragment>()

    fun addFragment(fragment : Fragment) {
        data.add(fragment)
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Fragment {
        return data[position]
    }
}