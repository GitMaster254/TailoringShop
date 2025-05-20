package com.example.tailoringshop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tailoringshop.data.AppDatabase
import com.example.tailoringshop.data.dao.ZipDao
import com.example.tailoringshop.data.models.ZipItem
import kotlinx.coroutines.launch

class ZipViewModel(application: Application) : AndroidViewModel(application) {

    private val zipDao: ZipDao = AppDatabase.getDatabase(application).zipDao()

    // Corrected to use getAllZipItems()
    val allZips: LiveData<List<ZipItem>> = zipDao.getAllZipItems()

    fun insertZip(zipItem: ZipItem) {
        viewModelScope.launch {
            // Corrected to use insertZipItem
            zipDao.insertZipItem(zipItem)
        }
    }

    fun updateZip(zipItem: ZipItem) {
        viewModelScope.launch {
            // Corrected to use updateZipItem
            zipDao.updateZipItem(zipItem)
        }
    }

    fun deleteZip(zipItem: ZipItem) {
        viewModelScope.launch {
            // Corrected to use deleteZipItem
            zipDao.deleteZipItem(zipItem)
        }
    }

    // Optional: If you want to expose deleting by ID from ViewModel
    fun deleteZipById(itemId: Int) {
        viewModelScope.launch {
            zipDao.deleteZipItemById(itemId)
        }
    }
}