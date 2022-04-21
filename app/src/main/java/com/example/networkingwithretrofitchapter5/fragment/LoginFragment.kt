package com.example.networkingwithretrofitchapter5.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.networkingwithretrofitchapter5.R
import com.example.networkingwithretrofitchapter5.databinding.FragmentLoginBinding
import com.example.networkingwithretrofitchapter5.request.LoginAdmin
import com.example.networkingwithretrofitchapter5.viewModel.LoginViewModel


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.loginButton.setOnClickListener {
            val email = binding.inputemailLoginEditText.text.toString()
            val password = binding.inpupasswordLoginEditText.text.toString()
            val loginUser = LoginAdmin(
                email,
                password
            )
            Log.d("LOGINFRAGMENT", loginUser.toString())
            viewModel.login(loginUser)
            viewModel.getCode().observe(viewLifecycleOwner){
                codeAPIresponse -> if (codeAPIresponse==201){
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                }
            }
        }
        binding.signUpButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }
    }

}