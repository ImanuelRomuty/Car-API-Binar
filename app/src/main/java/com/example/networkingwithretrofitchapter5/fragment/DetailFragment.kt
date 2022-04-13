package com.example.networkingwithretrofitchapter5.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.networkingwithretrofitchapter5.adapter.MainAdapter
import com.example.networkingwithretrofitchapter5.databinding.FragmentDetailBinding
class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private val arguments : DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments.user.name
        val price = arguments.user.price.toString()
        val category = arguments.user.category
        val createdAt       = arguments.user.createdAt
        val finishRentAt = arguments.user.finishRentAt
        val image       = arguments.user.image
        val startRentAt = arguments.user.startRentAt
        val status = arguments.user.status
        val updateAt = arguments.user.updatedAt
        binding.name.text = "Name : $name"
        binding.price.text ="Price : $price"
        binding.category.text= "Category : $category"
        binding.createdAt.text = "Created At : $createdAt"
        binding.finishRentAt.text = "Finish Rent : $finishRentAt"
        binding.startRentAt.text = "Start Rent : $startRentAt"
        binding.status.text = "Status :  ${status.toString()}"
        binding.updatedAt.text = "Status : $updateAt"

        Glide.with(this)
            .load(image)
            .into(binding.imageCar)
    }
}