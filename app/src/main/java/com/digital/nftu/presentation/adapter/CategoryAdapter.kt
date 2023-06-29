package com.digital.nftu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digital.nftu.R
import com.digital.nftu.data.response.local.Category
import com.digital.nftu.databinding.ItemLayoutCategoryBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var itemList = ArrayList<Category>()

    class CategoryViewHolder(private val binding: ItemLayoutCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category){
            binding.tvCategory.text = category.title

            if (category.isSelected){
                binding.tvCategory.background = binding.root.context.getDrawable(R.drawable.rectangle_bg_selected)
                binding.tvCategory.setTextColor(binding.root.context.getColor(R.color.white))
            } else {
                binding.tvCategory.background = binding.root.context.getDrawable(R.drawable.rectangle_et_bg)
                binding.tvCategory.setTextColor(binding.root.context.getColor(R.color.black))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemLayoutCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun setCategoryItems(items: ArrayList<Category>){
        itemList.addAll(items)
        notifyDataSetChanged()
    }
}