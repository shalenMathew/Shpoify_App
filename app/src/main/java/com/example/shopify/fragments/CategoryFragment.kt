package com.example.shopify.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopify.R
import com.example.shopify.adapter.CategoryAdapter
import com.example.shopify.databinding.FragmentCategoryBinding
import com.example.shopify.di.FakerApplication
import com.example.shopify.viewModel.MainViewModel
import com.example.shopify.viewModel.ViewModelFactory
import javax.inject.Inject


class CategoryFragment : Fragment() {

    lateinit var binding: FragmentCategoryBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentCategoryBinding.inflate(inflater, container, false)

        val application = requireActivity().application as FakerApplication

        application.applicationComponent.inject(this)

        val mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.getCategoryLiveData.observe(viewLifecycleOwner){

            binding.categoryRv.layoutManager=LinearLayoutManager(requireContext())
            val categoryAdapter = CategoryAdapter(requireContext(),it)
            binding.categoryRv.adapter=categoryAdapter

        }

        return  binding.root
    }


}