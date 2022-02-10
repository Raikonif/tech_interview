package com.example.tech_interview.ui.postdetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.tech_interview.R
import com.example.tech_interview.core.Resource
import com.example.tech_interview.data.model.Comment
import com.example.tech_interview.data.model.Post
import com.example.tech_interview.data.model.User
import com.example.tech_interview.data.remote.RemotePostDataSource
import com.example.tech_interview.databinding.FragmentDetailPostBinding
import com.example.tech_interview.presentation.UserViewModel
import com.example.tech_interview.presentation.UserViewModelFactory
import com.example.tech_interview.repository.Posts.PostRepositoryImpl
import com.example.tech_interview.repository.RetrofitClient
import com.example.tech_interview.ui.post.PostsFragment
import com.example.tech_interview.ui.postdetails.adapter.CommentAdapter


class DetailPostFragment : Fragment(R.layout.fragment_detail_post) {
    private lateinit var binding: FragmentDetailPostBinding
    private val args by navArgs<DetailPostFragmentArgs>()
    private val viewModel by viewModels<UserViewModel> {
        UserViewModelFactory(
            PostRepositoryImpl(
                RemotePostDataSource(RetrofitClient.webService)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailPostBinding.bind(view)
        viewModel.fetchUserAndComments().observe(
            viewLifecycleOwner, Observer { result ->
                when (result) {
                    is Resource.Loading -> {
                        binding.pbDetails.visibility = View.VISIBLE
                    }
                    is Resource.Success -> {
                        binding.pbDetails.visibility = View.GONE
                        binding.tvTitleDesc.visibility = View.VISIBLE
                        binding.rvCommentsFromPost.addItemDecoration(
                            DividerItemDecoration(
                                context,
                                DividerItemDecoration.HORIZONTAL
                            )
                        )

                        val userId = result.data.second.id
                        val postId = (Post::id).toString().toInt()

                        if (args.userId == userId && args.id == postId) {
                            binding.rvCommentsFromPost.adapter = CommentAdapter(result.data.first)
                            binding.tvUserName.text = result.data.second.name
                            binding.tvUserPhone.text = result.data.second.phone
                            binding.tvUserEmail.text = result.data.second.email
                            binding.tvUserWebsite.text = result.data.second.website
                        }
                    }
                    is Resource.Failure -> {
                        binding.pbDetails.visibility = View.GONE
                        Toast.makeText(context, "Loading Failured", Toast.LENGTH_SHORT).show()
                        Log.d("ErrorDetail","${result.exception}")
                    }
                }
            }
        )
    }


}