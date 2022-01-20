package com.juarez.androidhilt.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juarez.androidhilt.databinding.ItemUserBinding
import com.juarez.androidhilt.data.models.User

class UsersAdapter(
    private val data: ArrayList<User>,
    private val onItemClickListener: (user: User) -> Unit
) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    fun updateData(newData: List<User>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(data[position]) {
                binding.txtUserName.text = name

            }
            this.itemView.setOnClickListener { onItemClickListener(data[position]) }
        }
    }

    override fun getItemCount() = data.size
}