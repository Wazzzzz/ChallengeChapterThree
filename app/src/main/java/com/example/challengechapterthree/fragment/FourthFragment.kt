package com.example.challengechapterthree.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challengechapterthree.R
import com.example.challengechapterthree.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!
    private val args:FourthFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigateToThirdFragmentButton2.setOnClickListener {
            val inputName = args.name

            val personData = DataPerson(
                inputName,
                binding.ageEditText.text.toString().toInt(),
                binding.addressEditText.text.toString().trim(),
                binding.jobEditText.text.toString().trim()
            )

            val fourthFragment = FourthFragmentDirections.actionFourthFragmentToThirdFragment(personData)
            findNavController().navigate(fourthFragment)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}