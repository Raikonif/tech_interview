package com.example.tech_interview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tech_interview.databinding.FragmentDetailPostBinding


class DetailPostFragment : Fragment() {
    private lateinit var binding: FragmentDetailPostBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailPostBinding.bind(view)
    }
}