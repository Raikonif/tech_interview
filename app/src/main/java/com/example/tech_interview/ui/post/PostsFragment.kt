package com.example.tech_interview.ui.post

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.tech_interview.R
import com.example.tech_interview.core.Resource
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.data.remote.RemotePostDataSource
import com.example.tech_interview.databinding.FragmentPostsBinding
import com.example.tech_interview.presentation.PostViewModelFactory
import com.example.tech_interview.presentation.PostsViewModel
import com.example.tech_interview.repository.Posts.PostRepositoryImpl
import com.example.tech_interview.repository.RetrofitClient
import com.example.tech_interview.ui.post.adapter.PostAdapter

class PostsFragment : Fragment(R.layout.fragment_posts), PostAdapter.OnPostClickListener {
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
                    binding.pbPostList.visibility = View.VISIBLE
                    Log.d("LiveData", "Loading")
                }
                is Resource.Success -> {
                    binding.pbPostList.visibility = View.GONE
                    binding.rvPosts.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                    binding.rvPosts.adapter = PostAdapter(result.data, this)
                    Log.d("LiveData", "${result.data}")
                }
                is Resource.Failure -> Log.d("LiveData","${result.exception}")
            }
        })

    }

    override fun onPostClick(post: Post) {
        Log.d("Post", "OnPostClick${post}")
        val action = PostsFragmentDirections.actionPostsFragmentToDetailPostFragment(
            post.body,
            post.title,
            post.id,
            post.userId
        )
        findNavController().navigate(action)
        Log.d("Post", "OnPostClick: $post")

    }
}