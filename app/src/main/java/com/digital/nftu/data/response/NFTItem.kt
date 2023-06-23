package com.digital.nftu.data.response

data class NFTItem(
    val itemId: Int? = null,
    val title: String? = null,
    val ownedBy: String? = null,
    val userName: String? = null,
    val increasedBy: String? = null,
    val exchangeRate: String? = null,
    val currency: String? = null,
    val isFavorite: Boolean? = null,
)
