package com.example.somethingcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.example.somethingcheck.R
import kotlinx.android.synthetic.main.fragment_combo.view.*

class ComboFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_combo, container, false)

        comboFunction(view)
        return view
    }

    private fun comboFunction(view : View) {
        // button click event

        view.btnFragCombo.setOnClickListener {
            Toast.makeText(requireContext(), "${view.spinnerFrag.selectedItem}", Toast.LENGTH_SHORT).show()
        }
    }
}