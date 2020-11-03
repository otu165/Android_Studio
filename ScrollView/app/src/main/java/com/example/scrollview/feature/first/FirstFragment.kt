package com.example.scrollview.feature.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scrollview.R
import com.example.scrollview.feature.third.ThirdFragRvAdapter
import kotlinx.android.synthetic.main.fragment_fourth.view.*

// Horizontal Scroll View
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        firstFragFunction(view)
        return view
    }

    private fun firstFragFunction(view : View) {

    }
}