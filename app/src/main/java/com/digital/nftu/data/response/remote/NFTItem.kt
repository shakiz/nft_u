package com.digital.nftu.data.response.remote

data class NFTItem(
    val itemId: Int? = null,
    val title: String? = null,
    val ownedBy: String? = null,
    val creator: String? = null,
    val currentBid: String? = null,
    val highestBid: String? = null,
    val bidEndTime: String? = null,
    val category: String? = null,
    val description: String? = null,
    val userName: String? = null,
    val increasedBy: String? = null,
    val exchangeRate: String? = null,
    val currency: String? = null,
    val isFavorite: Boolean? = null,
    val itemBannerUrl: String? = null,
    val itemBannerImage: Int? = null,
)
