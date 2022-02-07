package com.example.tech_interview.data.model

import retrofit2.Call
import retrofit2.Response

data class Post(
    val userId: Int = -1,
    val id: Int = -1,
    val title: String = "",
    val body: String = ""
    )

data class postsList(val resultPostList: Response<List<Post>>)