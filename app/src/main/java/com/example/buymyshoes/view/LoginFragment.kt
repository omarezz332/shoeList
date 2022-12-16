package com.example.buymyshoes.view

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.buymyshoes.R
import com.example.buymyshoes.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.fragment_login, container, false
        )

        binding.buttonAcessar.setOnClickListener {
            login(context)

        }
        return binding.root
    }

    private fun login(context: Context?): View.OnClickListener? {


        if (checkIfEmailIsValid() && validPassword()) {
//            Toast.makeText(context, "Valid Form", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)

        } else {
            Toast.makeText(context, "Invalid Form", Toast.LENGTH_SHORT).show()
        }

        return null
    }

    private fun checkIfEmailIsValid(): Boolean {

        val emailInputText = binding.loginEmail.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(emailInputText).matches()) {
            binding.loginEmail.error = "Invalid Email Address"
            return false
        } else {
            binding.loginEmail.error = null
            return true
        }

    }

    private fun validPassword(): Boolean {
        val passwordText = binding.loginPassword.text.toString()
        if (passwordText.length < 8) {
            binding.loginPassword.error = "Minimum 8 Character Password"
            return false
        } else {
            binding.loginPassword.error = null
            return true
        }

    }


}