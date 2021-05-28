package com.example.eoffice.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eoffice.databinding.CustomItemInboxBinding
import com.example.eoffice.databinding.CustomItemOutboxBinding
import com.example.eoffice.view.activity.letter.DetailLetterActivity

class OutboxAdapter(private val activity: Activity): RecyclerView.Adapter<OutboxAdapter.ViewHolder>() {

    val data: ArrayList<Array<String>> = arrayListOf()

    class ViewHolder(view: CustomItemOutboxBinding): RecyclerView.ViewHolder(view.root) {
        val tvSubject = view.tvSubject
        val tvMessage = view.tvMessage
        val tvTime = view.tvWaktu
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CustomItemOutboxBinding = CustomItemOutboxBinding.inflate(LayoutInflater.from(activity), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val array = data[position]
        holder.tvSubject.text = array[0]
        holder.tvTime.text = array[1]
        holder.tvMessage.text = array[2]

        holder.itemView.setOnClickListener{
            val intent = Intent(activity, DetailLetterActivity::class.java)
            intent.putExtra("type", "out")
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(list: ArrayList<Array<String>>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}