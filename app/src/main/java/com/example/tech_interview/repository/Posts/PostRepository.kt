package com.example.tech_interview.repository.Posts


import com.example.tech_interview.data.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PostRepository {
    suspend fun getPostList (): List<Post>
    suspend fun getComments (): List<Comment>
    suspend fun getUser (): User
}