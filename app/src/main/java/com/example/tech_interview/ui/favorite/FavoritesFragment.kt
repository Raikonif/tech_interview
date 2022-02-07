package com.example.tech_interview.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.tech_interview.R
import com.example.tech_interview.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {
    private lateinit var binding: FragmentFavoritesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritesBinding.bind(view)

    }
}