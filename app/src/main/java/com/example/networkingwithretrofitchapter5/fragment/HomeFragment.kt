package com.example.networkingwithretrofitchapter5.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


import com.example.networkingwithretrofitchapter5.adapter.MainAdapter
import com.example.networkingwithretrofitchapter5.databinding.FragmentHomeBinding
import com.example.networkingwithretrofitchapter5.model.GetAllCarResponseItem

import com.example.networkingwithretrofitchapter5.network.CarsApi

import com.example.networkingwithretrofitchapter5.request.RegisterRequest
import com.example.networkingwithretrofitchapter5.model.RegisterResponseItem

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class HomeFragment : Fragment(){
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
/*    lateinit var listRecycler : RecyclerView*/

    private val list = ArrayList<GetAllCarResponseItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchAllData()


        binding.addButton.setOnClickListener {
/*            //PASSWORD HARUS 6 KARAKTER
            val registerRequest = RegisterRequest(
                "testing121wa2@gmail.com","112awe122","admin"
            )

            CarsApi.instance.registerAdmin(registerRequest).enqueue(object : Callback<RegisterResponseItem>{
                override fun onResponse(
                    call: Call<RegisterResponseItem>,
                    response: Response<RegisterResponseItem>
                ) {
                    Log.d("Register_Sukses","REGISTER DATA => ${response.body()}")
                }

                override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                    Log.d("FAIL","FAIL")
                }
            })*/
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRegisterFragment())
        }

    }
    private fun fetchAllData(){
        CarsApi.instance.AllCar().enqueue(object : Callback<List<GetAllCarResponseItem>>{
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
                val body = response.body()
                val code = response.code()
                if (code==200){
                    showList(body)
                }
            }
            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                Log.d("gagal","POKOK GAGAL DEH")
            }
        })
    }

    private fun showList(data: List<GetAllCarResponseItem>?){
        val adapter = MainAdapter(object : MainAdapter.OnClickListener{
            override fun onClickItem(data: GetAllCarResponseItem) {
            }
        })
        adapter.submitData(data)
        binding.recyclerView.adapter=adapter
    }
}
