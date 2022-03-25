package com.example.challengechapterthree.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challengechapterthree.R
import com.example.challengechapterthree.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputName = args.dataPerson?.name.toString()
        binding.nameTextView.text = inputName

        binding.navigateToFourthFragmentButton.setOnClickListener {
            val thirdFragment = ThirdFragmentDirections.actionThirdFragmentToFourthFragment(inputName)
            findNavController().navigate(thirdFragment)
        }

        val name = args.dataPerson?.name
        val age = args.dataPerson?.age
        val address = args.dataPerson?.address
        val job = args.dataPerson?.job


        if (age != null) {
            if (job != null && age %2 == 0){
                binding.nameTextView.text = "Nama: $name"
                binding.ageTextView.text = "Umur: $age bernilai genap"
                binding.addressTextView.text = "Alamat: $address"
                binding.jobTextView.text = "Pekerjaan: $job"
            }
            else if (job != null && age %2 != 0){
                binding.nameTextView.text = "Nama: $name"
                binding.ageTextView.text = "Umur: $age bernilai ganjil"
                binding.addressTextView.text = "Alamat: $address"
                binding.jobTextView.text = "Pekerjaan: $job"
            }
        }
        else {
            binding.nameTextView.text = "Nama: $name"
            binding.ageTextView.visibility = View.GONE
            binding.addressTextView.visibility = View.GONE
            binding.jobTextView.visibility = View.GONE
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}