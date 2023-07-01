package com.digital.nftu.data.source.local

import com.digital.nftu.data.response.remote.NFTItem

interface LocalSource {
    suspend fun getNFTItemList() : List<NFTItem>
}