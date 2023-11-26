package com.example.shopify.retrofit

import com.example.shopify.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProductData():Response<List<Product>>

    @GET("products/categories")
    suspend fun getCategoryArray():Response<List<String>>

    @GET("products/category/electronics")
    suspend fun getElectronics():Response<List<Product>>

}