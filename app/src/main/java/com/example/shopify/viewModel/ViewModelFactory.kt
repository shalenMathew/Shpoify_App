package com.example.shopify.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopify.repository.ProductRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: ProductRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}