package com.example.networkingwithretrofitchapter5.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkingwithretrofitchapter5.model.RegisterResponseItem
import com.example.networkingwithretrofitchapter5.network.CarsApi
import com.example.networkingwithretrofitchapter5.request.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistViewModel : ViewModel() {
//    private val regist : MutableLiveData<RegisterResponseItem> by lazy {
//        MutableLiveData<RegisterResponseItem>().also {
//            register()
//        }
//    }
    fun register(userData : RegisterRequest){
        CarsApi.instance.registerAdmin(userData).enqueue(object :
            Callback<RegisterResponseItem> {
            override fun onResponse(
                call: Call<RegisterResponseItem>,
                response: Response<RegisterResponseItem>
            ) {
                Log.d("Register_Sukses","REGISTER DATA => ${response.body()}")
            }

            override fun onFailure(call: Call<RegisterResponseItem>, t: Throwable) {
                Log.d("FAIL","FAIL")
            }
        })

    }
}