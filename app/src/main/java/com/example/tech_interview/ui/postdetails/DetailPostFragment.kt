package com.example.tech_interview.ui.postdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.tech_interview.R
import com.example.tech_interview.databinding.FragmentDetailPostBinding


class DetailPostFragment : Fragment(R.layout.fragment_detail_post) {
    private lateinit var binding: FragmentDetailPostBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailPostBinding.bind(view)

    }
}