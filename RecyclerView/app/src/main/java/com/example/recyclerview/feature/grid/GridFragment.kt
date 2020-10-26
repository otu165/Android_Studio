package com.example.recyclerview.feature.grid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class GridFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_grid, container, false)

        gridFunction(view)
        return view
    }

    private fun gridFunction(view : View) {
        // 1. RecyclerView
        val rv : RecyclerView = view.findViewById(R.id.rvGrid)
        val rvAdapter = GridRvAdapter(requireContext())

        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(requireContext(), 2)

        rvAdapter.notifyDataSetChanged()
    }
}