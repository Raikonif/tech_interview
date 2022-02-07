package com.example.tech_interview.repository


import com.example.tech_interview.data.model.Comment
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.data.model.User
import com.example.tech_interview.data.model.postsList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PostRepository {
    suspend fun getPostList (): Call<List<Post>>
    suspend fun getComments (): Call<List<Comment>>
    suspend fun getUser (): User
}