package com.digital.nftu.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.digital.nftu.data.response.remote.NFTItem
import com.digital.nftu.databinding.ItemLayoutNftProductCardSmallBinding
import com.digital.nftu.utils.orZero

class TopNFTProductAdapter: RecyclerView.Adapter<TopNFTProductAdapter.NFTProductViewHolder>() {

    private var itemList = ArrayList<NFTItem>()
    private var callBack: OnUserDetailsClickListener? = null

    class NFTProductViewHolder(private val binding: ItemLayoutNftProductCardSmallBinding, private val callBack: OnUserDetailsClickListener? = null) : RecyclerView.ViewHolder(binding.root) {
        fun bind(nftItem: NFTItem){
            binding.ivProductImage.setImageResource(nftItem.itemBannerImage.orZero())
            binding.tvUserName.text = nftItem.userName
            binding.tvFullName.text = nftItem.fullName
            binding.tvRateIncreasePercentage.text = nftItem.increasedBy
            binding.tvExchangeRate.text = nftItem.exchangeRate
            binding.recyclerItemContainer.setOnClickListener {
                callBack?.onUserDetails(nftItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NFTProductViewHolder {
        val binding = ItemLayoutNftProductCardSmallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NFTProductViewHolder(binding, callBack)
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

    fun setItemClickListener(callBack: OnUserDetailsClickListener? = null){
        this.callBack = callBack
    }

    interface OnUserDetailsClickListener{
        fun onUserDetails(user: NFTItem)
    }
}