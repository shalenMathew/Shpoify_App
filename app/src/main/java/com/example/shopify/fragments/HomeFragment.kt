package com.example.shopify.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.shopify.R
import com.example.shopify.adapter.ProductAdapter
import com.example.shopify.databinding.FragmentHomeBinding
import com.example.shopify.databinding.HomeItemBinding
import com.example.shopify.di.FakerApplication
import com.example.shopify.viewModel.MainViewModel
import com.example.shopify.viewModel.ViewModelFactory
import javax.inject.Inject


class HomeFragment : Fragment() {

    private lateinit var  mainViewModel:MainViewModel
    private lateinit var binding:FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       binding = FragmentHomeBinding.inflate(inflater, container, false)

        val application = requireActivity().application as FakerApplication

        application.applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        binding.mainRv.layoutManager=GridLayoutManager(context,2)
        val adapter = ProductAdapter(requireContext())
        binding.mainRv.adapter=adapter

        mainViewModel.productLiveData.observe(viewLifecycleOwner){

            productLiveData->

            val productArrayList = ArrayList(productLiveData)
            adapter.setList(productArrayList)
        }

       return binding.root

    }

}