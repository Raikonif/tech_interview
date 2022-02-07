package com.example.tech_interview.repository

import com.example.tech_interview.data.model.Comment
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.data.model.User
import com.example.tech_interview.data.remote.RemotePostDataSource
import retrofit2.Call
import retrofit2.Response

class PostRepositoryImpl(private val dataSourceRemote: RemotePostDataSource) : PostRepository {


    override suspend fun getPostList(): Call<List<Post>> {
        return dataSourceRemote.getPostList()
    }

    override suspend fun getComments(): Call<List<Comment>> {
        return  dataSourceRemote.getComments()
    }

    override suspend fun getUser(): User {
        return dataSourceRemote.getUser()
    }

}