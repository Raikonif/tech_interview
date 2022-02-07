package com.example.tech_interview.data.model

import retrofit2.Call


data class Comment(
    val postId: Int = -1,
    val id: Int = -1,
    val name: String = "",
    val email: String = "",
    val body: String = ""
)

data class CommentList(val resultCommentList: Call<List<Comment>>)