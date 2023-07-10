package com.betulnecanli.todoappfirebasesample.scenes.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.data.model.CheckList
import com.betulnecanli.todoappfirebasesample.databinding.ItemListBinding

class HomeAdapter(private val listener : OnItemClickListener)  : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    companion object{
        val diffCallBack = object : DiffUtil.ItemCallback<CheckList>(){
            override fun areItemsTheSame(oldItem: CheckList, newItem: CheckList): Boolean {
                return oldItem.document_id == newItem.document_id
            }

            override fun areContentsTheSame(oldItem: CheckList, newItem: CheckList): Boolean {
                return oldItem == newItem
            }

        }
    }

    val differ = AsyncListDiffer(this,diffCallBack)


    inner class ViewHolder(
        val binding : ItemListBinding) :RecyclerView.ViewHolder(binding.root){

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION){
                        val todo = differ.currentList[position]
                        listener.onItemClick(todo)

                    }
                }


            }
        }
            fun bind(title : CheckList){
                binding.itemText.text = title.list_name
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        val currentTitle = differ.currentList[position]
        holder.bind(currentTitle)

    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    interface OnItemClickListener{
        fun onItemClick( list : CheckList)



    }
}