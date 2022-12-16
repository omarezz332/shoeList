package com.example.buymyshoes.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.buymyshoes.R
import com.example.buymyshoes.databinding.FragmentShowListBinding
import com.example.buymyshoes.databinding.ShowItemBinding
import com.example.buymyshoes.viewModel.ShoeViewModel

@Suppress("DEPRECATION")
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
        setHasOptionsMenu(true)


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



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }


//    override fun onContextItemSelected(item: MenuItem): Boolean {
////        return NavigationUI.onNavDestinationSelected(
////            item,
////            requireView().findNavController()
////        ) || super.onOptionsItemSelected(item)
//        R.id.loginFragment -> {
//            // User chose the "Settings" item, show the app settings UI...
//            true
//        }
//
//        R.id.action_favorite -> {
//            // User chose the "Favorite" action, mark the current item
//            // as a favorite...
//            true
//        }
//
//        else -> {
//            // If we got here, the user's action was not recognized.
//            // Invoke the superclass to handle it.
//            super.onOptionsItemSelected(item)
//        }
//    }
override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
    R.id.loginFragment -> {
        findNavController().navigate(R.id.action_showListFragment_to_loginFragment)

        true
    }



    else -> {
        // If we got here, the user's action was not recognized.
        // Invoke the superclass to handle it.
        super.onOptionsItemSelected(item)
    }
}
}