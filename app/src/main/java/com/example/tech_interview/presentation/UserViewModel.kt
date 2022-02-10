package com.example.tech_interview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.tech_interview.core.Resource
import com.example.tech_interview.repository.Posts.PostRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class UserViewModel(private val repo: PostRepository) : ViewModel() {

    fun fetchUserAndComments() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(
                    Pair(
                        repo.getComments(),
                        repo.getUser()
                     )
                )
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class UserViewModelFactory(private val repo: PostRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(PostRepository::class.java).newInstance(repo)
    }
}