package com.example.scrollview.feature.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scrollview.R
import kotlinx.android.synthetic.main.fragment_third.view.*

// vertical scroll + Linear rv
class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        thirdFragFunction(view)
        return view
    }

    private fun thirdFragFunction(view : View) {
        // recycler view setting
        val adapter = ThirdFragRvAdapter(requireContext())
        view.rvThirdFrag.adapter = adapter
        view.rvThirdFrag.layoutManager = LinearLayoutManager(requireContext())
        adapter.notifyDataSetChanged()
    }
}