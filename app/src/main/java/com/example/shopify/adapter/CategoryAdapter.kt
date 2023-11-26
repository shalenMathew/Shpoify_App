package com.example.shopify.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shopify.ElectronicsActivity
import com.example.shopify.MainActivity
import com.example.shopify.R
import com.example.shopify.databinding.CategoryItemBinding
import com.example.shopify.databinding.FragmentCategoryBinding

class CategoryAdapter(private  val context:Context,private val categoryList: List<String>):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)

       return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {

        val category = categoryList.get(position)

        holder.binding.categoryItemTv.text= category

        holder.binding.categoryItemLayout.setOnClickListener(){

            if(category == "electronics"){
                val intent = Intent(context,ElectronicsActivity::class.java)
                context.startActivity(intent)

            }else{
                Toast.makeText(context, "Only electronics category is available coz all other category uses the same method to display data no use to creating  same thing again and again  ", Toast.LENGTH_SHORT).show()
            }
        }




    }

    override fun getItemCount(): Int {
    return categoryList.size
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

      var binding: CategoryItemBinding

        init {
            binding= CategoryItemBinding.bind(itemView)
        }

    }
}