package com.example.tech_interview.ui.post.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.databinding.ItemPostBinding
import com.example.tech_interview.ui.post.PostsFragment

class PostAdapter(
    private val postList: List<Post>,
    private val itemClickListener: OnPostClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPostClickListener {
        fun onPostClick(post: Post)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemPostBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        val holder = PostViewHolder(itemBinding, parent.context)
        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            }

                ?: return@setOnClickListener
            itemClickListener.onPostClick(postList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is PostViewHolder -> holder.bind(postList[position])
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    private inner class PostViewHolder(val binding: ItemPostBinding, val context: Context) :
        BaseViewHolder<Post>(binding.root) {
        override fun bind(item: Post) {
            item.userId
            item.id
            binding.tvPostTitle.text = item.title
            binding.tvPostDesc.text = item.body
        }
    }
}