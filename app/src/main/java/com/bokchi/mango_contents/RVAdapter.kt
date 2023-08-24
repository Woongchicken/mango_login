package com.bokchi.mango_contents

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bokchi.mango_contents.databinding.RvItemBinding
import com.bumptech.glide.Glide
import java.io.Serializable

class RVAdapter(val List : MutableList<ContentsModel>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val v = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(item : ContentsModel) {
            binding.rvTextArea.text = item.titleText

            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .into(binding.rvImageArea)

            binding.comRowid.setOnClickListener {
                val intent = Intent(binding.root.context, ViewActivity::class.java)
                intent.putExtra("url", item.url)
                intent.putExtra("title", item.titleText)
                intent.putExtra("imageUrl", item.imageUrl)
                binding.root.context.startActivity(intent)
            }
        }
    }
}