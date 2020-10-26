package com.example.recyclerview.feature.linear

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class LinearFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_linear, container, false)

        linearFunction(view)
        return view
    }

    private fun linearFunction(view : View) {
        // 1. RecyclerView
        val rv : RecyclerView = view.findViewById(R.id.rvLinear)
        val rvAdapter = LinearRvAdapter(requireContext())

        rv.adapter = rvAdapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        rvAdapter.notifyDataSetChanged()
    }
}