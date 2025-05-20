package com.example.tailoringshop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tailoringshop.data.AppDatabase
import com.example.tailoringshop.data.dao.OtherDao
import com.example.tailoringshop.data.models.OtherItem
import kotlinx.coroutines.launch

class OtherViewModel(application: Application) : AndroidViewModel(application) {

    private val otherDao: OtherDao = AppDatabase.getDatabase(application).otherDao()

    // Corrected to use getAllOtherItems()
    val allOthers: LiveData<List<OtherItem>> = otherDao.getAllOtherItems()

    fun insertOther(otherItem: OtherItem) {
        viewModelScope.launch {
            // Corrected to use insertOtherItem
            otherDao.insertOtherItem(otherItem)
        }
    }

    fun updateOther(otherItem: OtherItem) {
        viewModelScope.launch {
            // Corrected to use updateOtherItem
            otherDao.updateOtherItem(otherItem)
        }
    }

    fun deleteOther(otherItem: OtherItem) {
        viewModelScope.launch {
            // Corrected to use deleteOtherItem
            otherDao.deleteOtherItem(otherItem)
        }
    }

    // Optional: If you want to expose deleting by ID from ViewModel
    fun deleteOtherById(itemId: Int) {
        viewModelScope.launch {
            otherDao.deleteOtherItemById(itemId)
        }
    }
}