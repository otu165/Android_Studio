package com.example.onboarding.feature.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.onboarding.R
import kotlinx.android.synthetic.main.activity_onboarding.view.*
import kotlinx.android.synthetic.main.fragment_onboard.*
import kotlinx.android.synthetic.main.fragment_onboard.view.*

class OnboardFragment : Fragment() {
    var txt : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboard, container, false)

        onboardFunction(view)
        return view
    }

    private fun onboardFunction(view : View) {
        txt?.let {
            view.txtOnboard.text = txt
        }
    }
}