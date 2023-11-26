package com.example.shopify.di

import com.example.shopify.retrofit.Constant
import com.example.shopify.retrofit.FakerApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
class NetworkModule {

@Singleton
@Provides
    fun providesRetrofit():Retrofit{

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesFakerApi(retrofit: Retrofit):FakerApi{
        return retrofit.create(FakerApi::class.java)
    }

}