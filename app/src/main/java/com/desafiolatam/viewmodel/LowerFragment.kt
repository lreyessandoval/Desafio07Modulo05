package com.desafiolatam.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.viewmodel.databinding.FragmentLowerBinding

class LowerFragment : Fragment() {

    val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentLowerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentLowerBinding.inflate(layoutInflater, container, false)

        binding.tvLowerClick.setOnClickListener {
            if (!viewModel.isGameFinished()) {
                viewModel.increaseLower()
            } else {
                Toast.makeText(requireContext(), "¡BLACK PLAYER you WIN!", Toast.LENGTH_SHORT).show()

            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.lowerCounterStateFlow.collect {
                binding.tvLowerCounter.text = it.toString()
            }
        }

        binding.btnReset.setOnClickListener {
            viewModel.resetScores()
        }


        return binding.root

    }
}