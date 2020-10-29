package com.example.somethingcheck.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.somethingcheck.R
import kotlinx.android.synthetic.main.cb_frag_item.view.*
import kotlinx.android.synthetic.main.fragment_check.view.*
import kotlinx.android.synthetic.main.fragment_check.view.gvFragCheck

class CheckFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_check, container, false)

        checkFunction(view)
        return view
    }

    private fun checkFunction(view : View) {
        // compose GridView
        val gvAdapter = CheckGvAdapter(requireContext())
        view.gvFragCheck.adapter = gvAdapter

        // button click event
        view.btnFragCheck.setOnClickListener {
            printSelectedList(view, gvAdapter)
        }
    }



    fun printSelectedList(view : View, adapter: CheckGvAdapter) {
        var text : String = ""

        for(i in adapter.getColorList()) {
            if(i.value) {
                text += i.key + "\n"
            }
        }

        Log.d("TAG", "$text")

        view.txtFragCheck.text = text
    }
}