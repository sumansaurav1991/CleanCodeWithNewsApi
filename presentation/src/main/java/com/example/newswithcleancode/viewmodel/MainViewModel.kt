package com.example.newswithcleancode.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newswithcleancode.model.News
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {
    var selectedNews by mutableStateOf<News?>(null)
        private set

    fun selectNews(data: News) {
        selectedNews = data
    }

    fun unselectNews() {
        selectedNews = null
    }
}