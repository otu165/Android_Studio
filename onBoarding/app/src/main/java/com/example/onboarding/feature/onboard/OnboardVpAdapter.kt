package com.example.onboarding.feature.onboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class OnboardVpAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    var data = mutableListOf<Fragment>()

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