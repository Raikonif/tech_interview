package com.example.tech_interview.data.remote

import com.example.tech_interview.data.model.Comment
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.data.model.User
import com.example.tech_interview.repository.Constants
import com.example.tech_interview.repository.RetrofitClient.webService
import com.example.tech_interview.repository.WebService
import retrofit2.Call
import retrofit2.Response

class RemotePostDataSource(private val webService: WebService) {
    suspend fun getPostList(): Call<List<Post>> {
        return  webService.getPostList()
    }

    suspend fun getComments(): Call<List<Comment>>{
        return webService.getComments()
    }

    suspend fun getUser(): User{
        return webService.getUser()
    }
}