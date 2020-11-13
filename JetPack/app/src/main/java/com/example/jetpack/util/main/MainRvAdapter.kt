package com.example.jetpack.util.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R
import com.example.jetpack.models.user.User

class MainRvAdapter(
    private val context: Context,
    var data: MutableLiveData<List<User>>
) : RecyclerView.Adapter<MainRvAdapter.MainRvVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvVH {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_frag_first_item, parent, false)
        return MainRvVH(view)
    }

    override fun onBindViewHolder(holder: MainRvVH, position: Int) {
        data.value?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class MainRvVH(view: View) : RecyclerView.ViewHolder(view) {
        private val num: TextView = view.findViewById(R.id.txt_frag_first_number)
        private val data: TextView = view.findViewById(R.id.txt_frag_first_data)

        fun bind(user: User) {
            num.text = user.key.toString()
            data.text = user.string
        }
    }
}