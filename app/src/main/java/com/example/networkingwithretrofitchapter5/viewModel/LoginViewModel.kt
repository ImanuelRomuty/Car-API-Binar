package com.example.networkingwithretrofitchapter5.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkingwithretrofitchapter5.model.AdminLoginResponse
import com.example.networkingwithretrofitchapter5.network.CarsApi
import com.example.networkingwithretrofitchapter5.request.LoginAdmin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel:ViewModel() {

    val valid : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    fun getValid():LiveData<Int>{
        return valid
    }
    private  val respon :MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    fun getCode():LiveData<Int>{
        return respon
    }
    fun login(userData : LoginAdmin){
        CarsApi.instance.loginAdmin(userData)
            .enqueue(object : Callback<AdminLoginResponse>{
                override fun onResponse(
                    call: Call<AdminLoginResponse>,
                    response: Response<AdminLoginResponse>
                ) {
                    respon.value = response.code()
                    Log.d("LOGINCEKDATA",userData.toString())
                    Log.d("LOGINCEKCODE",respon.value.toString())
//                    valid.postValue(1)
                }

                override fun onFailure(call: Call<AdminLoginResponse>, t: Throwable) {
                    Log.d("LOGIN GAGAL","LOGIN GAGAL GAN")
//                    valid.postValue(0)
                }

            })
    }
}