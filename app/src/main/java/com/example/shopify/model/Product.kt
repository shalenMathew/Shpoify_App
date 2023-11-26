package com.example.shopify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(

    val id:Int,
    val title:String,
    val price:Double,
    val description:String,
    val category:String,
    val image:String,

):Parcelable
