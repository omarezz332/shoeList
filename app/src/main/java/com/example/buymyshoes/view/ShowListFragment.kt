package com.example.buymyshoes.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.buymyshoes.R
import com.example.buymyshoes.databinding.FragmentShowListBinding
import com.example.buymyshoes.databinding.ShowItemBinding
import com.example.buymyshoes.viewModel.ShoeViewModel

class ShowListFragment : Fragment() {


    private lateinit var shoeViewModel: ShoeViewModel
    private lateinit var showListBinding:FragmentShowListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        showListBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_show_list, container, false
        )

        //use requiredActivity() to create activity level viewModel
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]



        showListBinding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_showListFragment_to_shoeDetailsFragment)

        }
        shoeViewModel.shoes.observe(viewLifecycleOwner, Observer {
            for (shoe in it) {

                DataBindingUtil.inflate<ShowItemBinding>(
                    layoutInflater,
                    R.layout.show_item,
                    showListBinding.shoeList,
                    true
                ).apply {
                    this.shoe = shoe

                }
            }
        })

        return showListBinding.root
    }

}