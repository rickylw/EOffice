package com.example.eoffice.view.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eoffice.R
import com.example.eoffice.databinding.CustomItemInboxBinding
import com.example.eoffice.view.activity.disposition.DetailDispositionActivity

class DispositionInAdapter(private val activity: Activity): RecyclerView.Adapter<DispositionInAdapter.ViewHolder>() {

    val data: ArrayList<Array<String>> = arrayListOf()

    class ViewHolder(view: CustomItemInboxBinding): RecyclerView.ViewHolder(view.root) {
        val tvSender = view.tvPengirim
        val tvTime = view.tvWaktu
        val tvSubject = view.tvSubject
        val tvInstruction = view.tvPesan
        val ivStarred = view.ivStarred
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CustomItemInboxBinding = CustomItemInboxBinding.inflate(LayoutInflater.from(activity), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val array = data[position]
        holder.tvSender.text = array[0]
        holder.tvSubject.text = array[1]
        holder.tvTime.text = array[2]
        holder.tvInstruction.text = array[3]

        holder.ivStarred.setOnClickListener{
            holder.ivStarred.setImageResource(R.drawable.ic_starred)
        }

        holder.itemView.setOnClickListener{
            activity.startActivity(Intent(activity, DetailDispositionActivity::class.java))
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