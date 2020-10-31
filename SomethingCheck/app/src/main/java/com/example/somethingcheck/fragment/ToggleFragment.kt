package com.example.somethingcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.somethingcheck.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_toggle.view.*

class ToggleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_toggle, container, false)

        toggleFunction(view);
        return view;
    }

    private fun toggleFunction(view : View) {
        // toggle
        view.toggleFrag.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked) {
                Snackbar.make(view, "토글 ON", Snackbar.LENGTH_SHORT).show()
            }
        }

        // switch
        view.switchFrag.setOnCheckedChangeListener { compoundButton, isChecked ->
            if(isChecked) {
                Snackbar.make(view, "스위치 ON", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}