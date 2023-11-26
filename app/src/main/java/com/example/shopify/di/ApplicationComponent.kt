package com.example.shopify.di

import com.example.shopify.ElectronicsActivity
import com.example.shopify.MainActivity
import com.example.shopify.fragments.CategoryFragment
import com.example.shopify.fragments.HomeFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(homeFragment: HomeFragment)

    fun inject(categoryFragment: CategoryFragment)

    fun inject(electronicsActivity: ElectronicsActivity)
}