package com.example.tech_interview.ui.postdetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_interview.data.model.Comment
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.databinding.ItemCommentBinding
import com.example.tech_interview.databinding.ItemPostBinding
import com.example.tech_interview.ui.post.adapter.BaseViewHolder

class CommentAdapter(
    private val commentList: List<Comment>
) : RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemCommentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        val holder = CommentViewHolder(itemBinding, parent.context)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is CommentViewHolder -> holder.bind(commentList[position])
        }
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    private inner class CommentViewHolder(val binding: ItemCommentBinding, val context: Context) :
        BaseViewHolder<Comment>(binding.root) {
        override fun bind(item: Comment) {
            item.id
            item.postId
            binding.tvCommentItem.text = item.body
        }
    }
}