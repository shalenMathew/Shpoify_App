package com.example.shopify.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopify.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private  val repository: ProductRepository):ViewModel() {

    // we need fi to create the object for mainviewmodel but we cant directly create view model we need viewmodel fatorty

    init {
viewModelScope.launch {
    repository.getProducts()
    repository.getCategoryArray()
    repository.getElectronics()
}
    }

    val productLiveData get() = repository.getProductLiveData

    val getCategoryLiveData get() = repository.getCategoryLiveData

    val getEleLiveData get() = repository.getEleLiveData

}