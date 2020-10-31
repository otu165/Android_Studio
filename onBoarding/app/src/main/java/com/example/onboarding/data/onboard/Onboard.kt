package com.example.onboarding.data.onboard

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

// using SharedPreference
class Onboard private constructor() {
    fun setFirstLaunchToFalse() {
        editor!!.putBoolean(KEY, false).commit()
    }

    fun isItFirstLaunch() : Boolean {
        return sharedPreferences!!.getBoolean(KEY, true)
    }

    companion object {
        private val onboard = Onboard()
        private var sharedPreferences: SharedPreferences? = null
        private var editor : SharedPreferences.Editor? = null
        private val KEY = "first_lanuch"

        @Synchronized
        fun getInstance(context : Context) : Onboard {
            if(sharedPreferences == null) {
                sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                editor = sharedPreferences!!.edit()
            }

            return onboard
        }
    }
}