package com.example.shopify.di

import android.app.Application

class FakerApplication:Application() {

    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()

        // this will created at the beginning as soon as the app is opened
        applicationComponent=DaggerApplicationComponent.builder().build()
    }
}