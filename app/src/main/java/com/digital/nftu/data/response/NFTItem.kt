package com.digital.nftu.data.response

data class NFTItem(
    val itemId: Int,
    val title: String,
    val ownedBy: String,
    val userName: String,
    val increasedBy: String,
    val exchangeRate: String,
    val currency: String,
    val isFavorite: Boolean,
)
