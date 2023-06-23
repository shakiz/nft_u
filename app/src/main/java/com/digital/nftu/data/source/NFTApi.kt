package com.digital.nftu.data.source

import com.digital.nftu.data.response.NFTItem

interface NFTApi {
    suspend fun getNFTItems() : List<NFTItem>
}