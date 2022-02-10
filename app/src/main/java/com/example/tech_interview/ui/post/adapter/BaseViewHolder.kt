package com.example.tech_interview.ui.post.adapter

import android.view.View
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View):RecyclerView.ViewHolder(itemView) {
    abstract fun bind (item: T)
}