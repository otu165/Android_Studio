package com.example.somethingcheck.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.somethingcheck.fragment.*

class MainVpAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    var data = listOf<Fragment>(
        CheckFragment(),
        RadioFragment(),
        ComboFragment(),
            ToggleFragment(),
            PickerFragment()
    )

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Fragment {
        return data[position]
    }
}