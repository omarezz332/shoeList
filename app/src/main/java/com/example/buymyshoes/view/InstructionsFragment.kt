package com.example.buymyshoes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.buymyshoes.R
import com.example.buymyshoes.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
private lateinit var instructionsBinding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        instructionsBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_instructions, container, false
        )
        // Inflate the layout for this fragment
        instructionsBinding.continueBtn2.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_showListFragment)

        }
        return instructionsBinding.root
    }
}