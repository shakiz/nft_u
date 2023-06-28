package com.digital.nftu.data.source.remote

import com.digital.nftu.data.response.remote.NFTItem

interface RemoteSource {
    suspend fun getNFTItemList() : List<NFTItem>
}