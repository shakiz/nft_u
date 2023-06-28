package com.digital.nftu.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digital.nftu.data.repository.NFTRepository
import com.digital.nftu.data.response.remote.NFTItem
import kotlinx.coroutines.launch

class NFTViewModel(private val nftRepository: NFTRepository) :
    ViewModel() {

    val nftItemList = MutableLiveData<List<NFTItem>>()

    fun getNFTItems() = viewModelScope.launch {
        val response = nftRepository.fetchNFTItems()
        nftItemList.postValue(response)
    }
}