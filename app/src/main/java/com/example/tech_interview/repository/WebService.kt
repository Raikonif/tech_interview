package com.example.tech_interview.repository

import com.example.tech_interview.data.model.Comment
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.data.model.User
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("posts")
    suspend fun getPostList(): Call<List<Post>>
    @GET("comments")
    suspend fun getComments():  Call<List<Comment>>
    @GET("users")
    suspend fun getUser(): User

}

object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory
                    .create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}