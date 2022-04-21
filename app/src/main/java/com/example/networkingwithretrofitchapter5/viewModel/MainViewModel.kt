package com.example.networkingwithretrofitchapter5.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkingwithretrofitchapter5.model.GetAllCarResponseItem
import com.example.networkingwithretrofitchapter5.model.RegisterResponseItem
import com.example.networkingwithretrofitchapter5.network.CarsApi
import com.example.networkingwithretrofitchapter5.request.RegisterRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _loading = MutableLiveData<String>()

    private val _cars = MutableLiveData<List<GetAllCarResponseItem>>()
    val cars : LiveData<List<GetAllCarResponseItem>>
        get() = _cars

//    private val _code = MutableLiveData<Int>()
//    val code : LiveData<Int>
//    get() = _code




    init {
        loadCars()
    }
/*    private val cars: MutableLiveData<List<GetAllCarResponseItem>> by lazy {
        MutableLiveData<List<GetAllCarResponseItem>>().also {
            loadCars()
        }
    }

    fun getCars():LiveData<List<GetAllCarResponseItem>>{
        return cars
    }*/

    private fun loadCars() {
        CarsApi.instance.AllCar().enqueue(object : Callback<List<GetAllCarResponseItem>> {
            override fun onResponse(
                call: Call<List<GetAllCarResponseItem>>,
                response: Response<List<GetAllCarResponseItem>>
            ) {
                _cars.value = response.body()
            }
            override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                Log.d("gagal","POKOK GAGAL DEH")
            }
        })
    }





}