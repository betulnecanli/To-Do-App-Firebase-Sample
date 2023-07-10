package com.betulnecanli.todoappfirebasesample.scenes.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.data.model.Task
import com.betulnecanli.todoappfirebasesample.databinding.ItemListDetailBinding

class DetailAdapter: RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    companion object{
        val diffCallBack = object : DiffUtil.ItemCallback<Task>(){
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.addedDate == newItem.addedDate
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }

        }
    }

    val differ = AsyncListDiffer(this,diffCallBack)


    inner class ViewHolder(
        private val binding : ItemListDetailBinding
    ) :RecyclerView.ViewHolder(binding.root){


        fun bind(task : Task){
            binding.itemTextDetail.text = task.title
            if (task.check){
                binding.itemClDetail.setBackgroundResource(R.drawable.bg_item_green)
                }
            else{
                binding.itemClDetail.setBackgroundResource(R.drawable.bg_item)

            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAdapter.ViewHolder {
        return ViewHolder(
            ItemListDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailAdapter.ViewHolder, position: Int) {
        val currentTitle = differ.currentList[position]
        holder.bind(currentTitle)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}