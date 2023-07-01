package com.digital.nftu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digital.nftu.R
import com.digital.nftu.data.response.remote.NFTItem
import com.digital.nftu.databinding.ItemLayoutNftProductCardBinding
import com.digital.nftu.databinding.ItemLayoutNftProductCardSmallBinding
import com.digital.nftu.utils.orFalse
import com.digital.nftu.utils.orZero

class TopNFTProductAdapter: RecyclerView.Adapter<TopNFTProductAdapter.NFTProductViewHolder>() {

    private var itemList = ArrayList<NFTItem>()

    class NFTProductViewHolder(private val binding: ItemLayoutNftProductCardSmallBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nftItem: NFTItem){
            binding.ivProductImage.setImageResource(nftItem.itemBannerImage.orZero())
            binding.tvUserName.text = nftItem.userName
            binding.tvFullName.text = nftItem.fullName
            binding.tvRateIncreasePercentage.text = nftItem.increasedBy
            binding.tvExchangeRate.text = nftItem.exchangeRate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NFTProductViewHolder {
        val binding = ItemLayoutNftProductCardSmallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NFTProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: NFTProductViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun setNFTItems(items: ArrayList<NFTItem>){
        itemList.addAll(items)
        notifyDataSetChanged()
    }
}