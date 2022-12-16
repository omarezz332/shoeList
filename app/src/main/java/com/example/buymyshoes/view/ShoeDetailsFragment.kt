package com.example.buymyshoes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.buymyshoes.R
import com.example.buymyshoes.databinding.FragmentInstructionsBinding
import com.example.buymyshoes.databinding.FragmentShoeDetailsBinding
import com.example.buymyshoes.databinding.ShowItemBinding
import com.example.buymyshoes.models.ShoeModel
import com.example.buymyshoes.viewModel.ShoeViewModel


class ShoeDetailsFragment : Fragment() {

private lateinit var shoeDetailsBinding: FragmentShoeDetailsBinding
    private lateinit var itemBinding: ShowItemBinding

private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        shoeDetailsBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_shoe_details, container, false
        )
         itemBinding=DataBindingUtil.inflate(
            layoutInflater, R.layout.show_item, container, false
        )
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        shoeDetailsBinding.shoe=ShoeModel("","","")
        shoeDetailsBinding.viewModel=shoeViewModel
        shoeDetailsBinding.addItemBtn.setOnClickListener{
            shoeViewModel.addShoe(shoeDetailsBinding.shoe?: ShoeModel("","",""))
            findNavController().navigateUp()
        }
        shoeDetailsBinding.cancelBtn.setOnClickListener{
            findNavController().navigateUp()
        }
        return shoeDetailsBinding.root
    }

}