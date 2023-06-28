package com.digital.nftu.data.repository

import com.digital.nftu.data.response.remote.NFTItem
import com.digital.nftu.data.source.remote.RemoteSource

class NFTRepositoryImpl(val remoteSource: RemoteSource) : NFTRepository{
    override suspend fun fetchNFTItems(): List<NFTItem> {
        return remoteSource.getNFTItemList()
    }
}