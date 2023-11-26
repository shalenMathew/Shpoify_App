package com.example.shopify.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopify.R
import com.example.shopify.databinding.HomeItemBinding
import com.example.shopify.model.Product


class ProductAdapter(private val context:Context): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

private  var productListView:ArrayList<Product> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {

        val product=productListView.get(position)

        Glide.with(context).load(product.image).into(holder.binding.homeItemImg)
        holder.binding.homeItemTitle.text=product.title
        holder.binding.homeItemPrice.text="Price - " + product.price.toString()


    }

    override fun getItemCount(): Int {
       return productListView.size

    }

    fun setList(productListView:ArrayList<Product>){
        this.productListView.clear()
        this.productListView=productListView
        notifyDataSetChanged()

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

       lateinit var binding:HomeItemBinding

       init {
           binding = HomeItemBinding.bind(itemView)
       }


    }
}