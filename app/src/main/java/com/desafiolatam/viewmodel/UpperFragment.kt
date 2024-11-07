package com.desafiolatam.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.viewmodel.databinding.FragmentUpperBinding

class UpperFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentUpperBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUpperBinding.inflate(layoutInflater, container, false)

        binding.tvUpperClick.setOnClickListener {
            if (!viewModel.isGameFinished()) {
                viewModel.increaseUpper()
            } else {
                Toast.makeText(requireContext(), "¡WHITE PLAYER you WIN!", Toast.LENGTH_SHORT).show()
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.upperCounterStateFlow.collect {
                binding.tvUpperCounter.text = it.toString()
            }

        }

        return binding.root
    }
}