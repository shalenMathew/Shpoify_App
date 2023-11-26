package com.example.shopify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopify.adapter.CustomViewPagerAdapter
import com.example.shopify.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

val tabName = arrayOf("Home","Category")

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val customViewPagerAdapter = CustomViewPagerAdapter(supportFragmentManager,lifecycle)

        binding.vp.adapter=customViewPagerAdapter



      TabLayoutMediator(binding.tabLayout,binding.vp){
          tab,position ->tab.text=tabName[position]
      }.attach()


    }
}