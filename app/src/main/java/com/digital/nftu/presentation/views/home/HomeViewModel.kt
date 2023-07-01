package com.digital.nftu.presentation.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digital.nftu.R
import com.digital.nftu.data.response.local.Category
import com.digital.nftu.data.response.remote.NFTItem

class HomeViewModel : ViewModel() {
    private val categories = MutableLiveData<ArrayList<Category>>()
    private val nftProducts = MutableLiveData<ArrayList<NFTItem>>()
    private val topNftProducts = MutableLiveData<ArrayList<NFTItem>>()

    fun onCategoryItemsUpdated() : LiveData<ArrayList<Category>> = categories

    fun onNftItemsUpdated() : LiveData<ArrayList<NFTItem>> = nftProducts

    fun onTopNftProductsUpdated() : LiveData<ArrayList<NFTItem>> = topNftProducts

    fun fetchCategoryItems(){
        categories.postValue(
            arrayListOf(
                Category(isSelected = true, title = "All"),
                Category(isSelected = false, title = "Gaming"),
                Category(isSelected = false, title = "Sports"),
                Category(isSelected = false, title = "Music"),
                Category(isSelected = false, title = "Arcade"),
                Category(isSelected = false, title = "Sports"),
                Category(isSelected = false, title = "Portfolio"),
            )
        )
    }

    fun fetchNftItems(){
        nftProducts.postValue(
            arrayListOf(
                NFTItem(
                    isFavorite = true,
                    ownedBy = "KevGenki",
                    exchangeRate = "5,029 ETH",
                    itemBannerImage = R.drawable.nft_product,
                    userName = "Avril15"
                ),
                NFTItem(
                    isFavorite = false,
                    ownedBy = "Pansi74",
                    exchangeRate = "1,039 ETH",
                    itemBannerImage = R.drawable.nft_product_2,
                    userName = "KevGenki42"
                ),
                NFTItem(
                    isFavorite = false,
                    ownedBy = "Monika35",
                    exchangeRate = "2,299 ETH",
                    itemBannerImage = R.drawable.nft_product_3,
                    userName = "Pansi74"
                ),
            )
        )
    }

    fun fetchTopNftItems(){
        topNftProducts.postValue(
            arrayListOf(
                NFTItem(
                    fullName = "Monika Jova",
                    userName = "@monika",
                    itemBannerImage = R.drawable.small_product_1,
                    exchangeRate = "3,089",
                    increasedBy = "+58.00%"
                ),
                NFTItem(
                    fullName = "Synthia Asia",
                    userName = "@Synthi",
                    itemBannerImage = R.drawable.small_product_2,
                    exchangeRate = "1,189",
                    increasedBy = "+58.00%"
                ),
                NFTItem(
                    fullName = "Alan Joy",
                    userName = "@joy",
                    itemBannerImage = R.drawable.small_product_3,
                    exchangeRate = "4,989",
                    increasedBy = "+58.00%"
                ),
            )
        )
    }
}