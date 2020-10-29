package com.example.somethingcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.example.somethingcheck.R
import kotlinx.android.synthetic.main.fragment_radio.view.*

class RadioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_radio, container, false)

        radioFunction(view)
        return view
    }

    private fun radioFunction(view : View) {
        // button click event
        view.btnFragRadio.setOnClickListener {
            val id = view.rgFragRadio.checkedRadioButtonId
            val rb = view.findViewById<RadioButton>(id)

            Toast.makeText(requireContext(), "${rb.text}", Toast.LENGTH_SHORT).show()
        }
    }
}