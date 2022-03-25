package com.example.challengechapterthree.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.challengechapterthree.R
import com.example.challengechapterthree.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateToThirdFragmentButton.setOnClickListener {
            val inputName = DataPerson(
                binding.nameEditText.text.toString()
            )
            val secondFragmentAction = SecondFragmentDirections.actionSecondFragmentToThirdFragment(inputName)
            findNavController().navigate(secondFragmentAction)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}