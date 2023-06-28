package com.digital.nftu.data.sourceimpl.remote

import com.digital.nftu.data.response.remote.NFTItem
import com.digital.nftu.data.source.NFTApi
import com.digital.nftu.data.source.remote.RemoteSource

class RemoteSourceImpl(val api: NFTApi) : RemoteSource {
    override suspend fun getNFTItemList(): List<NFTItem> {
        return api.getNFTItems()
    }
}