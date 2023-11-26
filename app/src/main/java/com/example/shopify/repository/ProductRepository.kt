package com.example.shopify.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shopify.model.Product
import com.example.shopify.retrofit.FakerApi
import javax.inject.Inject


// inject constructor will create the obj for repos story instead of making a constructor like in java
class ProductRepository @Inject constructor(private val fakerApi: FakerApi){

    // fakerApi: FakerApi will be provided by Dagger, we told dagger in the module how to create an object of fakerApi

    private val productLiveData = MutableLiveData<List<Product>>()
    val getProductLiveData:LiveData<List<Product>> get() = productLiveData

    private val categoryLiveData= MutableLiveData<List<String>>()
    val getCategoryLiveData:LiveData<List<String>> get() = categoryLiveData

    private val electronicLiveData = MutableLiveData<List<Product>>()
    val getEleLiveData get() = electronicLiveData


   suspend fun getProducts(){
       // fetch products
        val result = fakerApi.getProductData()
        if (result.isSuccessful && result.body()!=null){
            productLiveData.postValue(result.body())
        }
    }

    suspend fun getCategoryArray(){
        val result = fakerApi.getCategoryArray()
        if (result.isSuccessful && result.body()!=null){
            categoryLiveData.postValue(result.body())
        }
    }

    suspend fun getElectronics(){

        val result = fakerApi.getElectronics()

        if (result.isSuccessful && result.body()!=null){

            electronicLiveData.postValue(result.body())

        }

    }

}