package com.digital.nftu.presentation.views.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digital.nftu.data.response.local.Category

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val categories = MutableLiveData<ArrayList<Category>>()

    fun onCategoryItemsUpdated() : LiveData<ArrayList<Category>> = categories

    fun fetchCategoryItems(){
        categories.postValue(
            arrayListOf(
                Category(isSelected = true, title = "All"),
                Category(isSelected = false, title = "Gaming"),
                Category(isSelected = false, title = "Sports"),
                Category(isSelected = false, title = "Music"),
                Category(isSelected = false, title = "Arcade"),
            )
        )
    }
}