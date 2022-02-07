package com.example.tech_interview.ui.post

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.tech_interview.R
import com.example.tech_interview.core.Resource
import com.example.tech_interview.data.remote.RemotePostDataSource
import com.example.tech_interview.databinding.FragmentPostsBinding
import com.example.tech_interview.presentation.PostViewModelFactory
import com.example.tech_interview.presentation.PostsViewModel
import com.example.tech_interview.repository.PostRepository
import com.example.tech_interview.repository.PostRepositoryImpl
import com.example.tech_interview.repository.RetrofitClient

class PostsFragment : Fragment(R.layout.fragment_posts) {
    private lateinit var binding: FragmentPostsBinding
    private val viewModel by viewModels<PostsViewModel> {
        PostViewModelFactory(
            PostRepositoryImpl(
                RemotePostDataSource(RetrofitClient.webService)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostsBinding.bind(view)
        viewModel.fetchMainScreenPosts().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading")
                }
                is Resource.Success -> {
                    Log.d("LiveData", "${result.data}")
                }
                is Resource.Failure -> {Log.d("LiveData","${result.exception}")}
            }
        })
    }
}