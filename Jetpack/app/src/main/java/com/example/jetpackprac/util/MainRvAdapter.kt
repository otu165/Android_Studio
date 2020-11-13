package com.example.jetpackprac.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackprac.R
import com.example.jetpackprac.model.Text
import com.example.jetpackprac.view.main.MainViewModel

class MainRvAdapter(
    private val context: Context,
    val mainViewModel: MainViewModel,
) : RecyclerView.Adapter<MainRvAdapter.MainRvViewHolder>() {
    private var data = listOf<Text>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_main_item, parent, false)
        return MainRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainRvViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    fun updateData(data: List<Text>) {
        this.data = data
        notifyDataSetChanged() // Adapter 내부에서 직접적으로 notifyDataSetChanged 호출 가능
    }

    inner class MainRvViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val view: View = view
        private val number: TextView = view.findViewById(R.id.txt_rv_main_item_number)
        private val txt: TextView = view.findViewById(R.id.txt_rv_main_item_text)

        fun bind(text: Text) {
            number.text = text.id.toString()
            txt.text = text.text

            view.setOnClickListener {
                mainViewModel.delete(text)
            }
        }
    }

    companion object {
        private const val TAG = "MainRvAdapter"
    }
}