package com.example.networkingwithretrofitchapter5.fragment

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.networkingwithretrofitchapter5.R
import com.example.networkingwithretrofitchapter5.databinding.FragmentRegisterBinding
import com.example.networkingwithretrofitchapter5.model.RegisterResponseItem
import com.example.networkingwithretrofitchapter5.network.CarsApi
import com.example.networkingwithretrofitchapter5.request.RegisterRequest
import com.example.networkingwithretrofitchapter5.viewModel.RegistViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel : RegistViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signUpButton.setOnClickListener {
            val email = binding.inputEmailEditText.text.toString()
            val password = binding.inputPasswordEditText.text.toString()
            val emailCheck = "@gmail.com"
            val registerCheckEmpty =RegisterRequest(email,password)
            when{
                email.isNullOrEmpty()-> {
                    binding.materialUsername.error = "Required Input"
                }
                password.isNullOrEmpty()-> {
                    binding.materialPassword.error = "Required Input"
                }
                (password.length <= 6 ) -> {
                    binding.materialPassword.error = "Password must consist of 6 characters"
                }
                (emailCheck !in email) -> {
                    binding.materialUsername.error = "Email must @gmail.com"
                }
                else ->{
/*                    CarsApi.instance.registerAdmin(registerRequest = registerCheckEmpty).enqueue(object  : Callback<RegisterResponseItem>{
                        override fun onResponse(
                            call: Call<RegisterResponseItem>,
                            response: Response<RegisterResponseItem>
                        ) {
                            val dialog = AlertDialog.Builder(requireContext())
                            dialog.setTitle("SUKSES")
                            dialog.setMessage("SUKSES MELAKUKAN REGISTER")
                            dialog.setCancelable(true)
                            dialog.show()
                        }

                        override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                            Log.d("FAILRESPONSE","GAGAL POKOKK")
                        }
                    })*/
//                    viewModel.regist.observe(viewLifecycleOwner){
//                        daftar ->
                    viewModel.register(registerCheckEmpty)
                    findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                    }

//                    findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
                }
            }
        }







/**        binding.signUpButton.setOnClickListener {
            //PASSWORD HARUS 6 KARAKTER
            //EMAIL HARUS MENGGUNAKAN @
            val registerRequest = RegisterRequest(
                email = email,password= password
            )
            CarsApi.instance.registerAdmin(registerRequest).enqueue(object :
                Callback<RegisterResponseItem> {
                override fun onResponse(
                    call: Call<RegisterResponseItem>,
                    response: Response<RegisterResponseItem>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code==201){
                        val dialog = AlertDialog.Builder(requireContext())
                        dialog.setTitle("SUKSES")
                        dialog.setMessage("SUKSES MELAKUKAN REGISTER")
                        dialog.setCancelable(true)
                        dialog.show()
                    }
                }
                override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                    Log.d("FAILRESPONSE","GAGAL POKOKK")
                }
            })
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
        }*/



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}