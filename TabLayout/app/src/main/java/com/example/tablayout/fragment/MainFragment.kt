package com.example.tablayout.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tablayout.R

class MainFragment : Fragment() {
    var s : String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        fragmentFunction(view)
        return view
    }

    private fun fragmentFunction(view : View) {
        s?.let {
            view.findViewById<TextView>(R.id.txtFragment).text = s

            if(s == "2") {
                view.findViewById<TextView>(R.id.txtFragment).setBackgroundColor(resources.getColor(R.color.orange))
            }
            else {
                view.findViewById<TextView>(R.id.txtFragment).setBackgroundColor(resources.getColor(R.color.yellow))
            }
        }
    }
}