package com.example.somethingcheck.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.somethingcheck.fragment.CheckFragment
import com.example.somethingcheck.fragment.ComboFragment
import com.example.somethingcheck.fragment.RadioFragment

class MainVpAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    var data = listOf<Fragment>(
        CheckFragment(),
        RadioFragment(),
        ComboFragment()
    )

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return data[position]
    }
}