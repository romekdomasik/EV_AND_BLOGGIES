package com.example.evaland2_bloggies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.evaland2_bloggies.databinding.FragmentMainBinding
import kotlinx.coroutines.Dispatchers.Main


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val facebookBtn = binding.facebookBtn
        val twitterBtn = binding.twitterBtn
        val bloggies = binding.bloggiesBtn

        facebookBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToFacebookFragment())
        }
        twitterBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToTwitterFragment())
        }

        bloggies.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToBloggiesFragment())
        }

    }

    }

