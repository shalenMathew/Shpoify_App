package com.example.shopify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shopify.adapter.ProductAdapter
import com.example.shopify.databinding.ActivityElectronicsBinding
import com.example.shopify.di.FakerApplication
import com.example.shopify.model.Product
import com.example.shopify.viewModel.MainViewModel
import com.example.shopify.viewModel.ViewModelFactory
import javax.inject.Inject

class ElectronicsActivity : AppCompatActivity() {

    lateinit var binding:ActivityElectronicsBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityElectronicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eleRv.layoutManager =GridLayoutManager(this,2)
        val productAdapter = ProductAdapter(this)
        binding.eleRv.adapter =  productAdapter

        val application = application as FakerApplication
        application.applicationComponent.inject(this)

        val mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.getEleLiveData.observe(this){
            val eleList = ArrayList<Product>(it)
            productAdapter.setList(eleList)

        }


    }
}