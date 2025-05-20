package com.example.tailoringshop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tailoringshop.data.AppDatabase
import com.example.tailoringshop.data.dao.CottonDao
import com.example.tailoringshop.data.models.CottonItem
import kotlinx.coroutines.launch

class CottonViewModel(application: Application) : AndroidViewModel(application) {

    private val cottonDao: CottonDao = AppDatabase.getDatabase(application).cottonDao()

    // Corrected to use getAllCottonItems
    val allCotton: LiveData<List<CottonItem>> = cottonDao.getAllCottonItems()

    fun insertCotton(cottonItem: CottonItem) {
        viewModelScope.launch {
            // Corrected to use insertCottonItem
            cottonDao.insertCottonItem(cottonItem)
        }
    }

    fun updateCotton(cottonItem: CottonItem) {
        viewModelScope.launch {
            // Corrected to use updateCottonItem
            cottonDao.updateCottonItem(cottonItem)
        }
    }

    fun deleteCotton(cottonItem: CottonItem) {
        viewModelScope.launch {
            // Corrected to use deleteCottonItem
            cottonDao.deleteCottonItem(cottonItem)
        }
    }
}