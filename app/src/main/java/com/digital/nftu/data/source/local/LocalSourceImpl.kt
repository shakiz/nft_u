package com.digital.nftu.data.source.local

import com.digital.nftu.data.response.remote.NFTItem
import com.digital.nftu.data.source.local.LocalSource

class LocalSourceImpl : LocalSource {
    override suspend fun getNFTItemList(): List<NFTItem> {
        TODO("Not yet implemented")
    }
}