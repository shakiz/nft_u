package com.digital.nftu.data.repository

import com.digital.nftu.data.response.remote.NFTItem

interface NFTRepository {
    suspend fun fetchNFTItems(): List<NFTItem>
}