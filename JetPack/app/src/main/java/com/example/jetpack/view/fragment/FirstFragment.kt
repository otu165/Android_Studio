package com.example.jetpack.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.jetpack.R
import com.example.jetpack.data.room.UserDatabase
import com.example.jetpack.models.user.User
import com.example.jetpack.util.main.MainRvAdapter
import com.example.jetpack.view.main.MainViewModel
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {
    val args: FirstFragmentArgs by navArgs() // 데이터 받기
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView
        val rvAdapter = MainRvAdapter(requireContext(), mainViewModel.rvLiveData)
        rv_frag_first.adapter = rvAdapter
        rv_frag_first.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)
        rvAdapter.notifyDataSetChanged()

        // LiveData

    }

    companion object {
        private const val TAG = "FirstFragment"
    }
}