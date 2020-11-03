package com.example.scrollview.feature.fourth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.scrollview.R
import com.example.scrollview.api.Service
import com.example.scrollview.feature.third.ThirdFragRvAdapter
import kotlinx.android.synthetic.main.fragment_fourth.view.*

// vertical scroll + Gird rv
class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fourth, container, false)

        fourthFragFunction(view)
        return view
    }

    private fun fourthFragFunction(view: View) {
        // recycler view setting
        val adapter = ThirdFragRvAdapter(requireContext())
        view.rvFourthFrag.adapter = adapter
        view.rvFourthFrag.layoutManager = GridLayoutManager(requireContext(), 2)

        adapter.data = Service.getFourthRvData()
        adapter.notifyDataSetChanged()
    }

}