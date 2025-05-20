package com.example.tailoringshop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tailoringshop.data.AppDatabase
import com.example.tailoringshop.data.dao.ElasticDao
import com.example.tailoringshop.data.models.ElasticItem
import kotlinx.coroutines.launch

class ElasticViewModel(application: Application) : AndroidViewModel(application) {

    private val elasticDao: ElasticDao = AppDatabase.getDatabase(application).elasticDao()

    // Corrected to use getAllElasticItems()
    val allElastic: LiveData<List<ElasticItem>> = elasticDao.getAllElasticItems()

    fun insertElastic(elasticItem: ElasticItem) {
        viewModelScope.launch {
            // Corrected to use insertElasticItem
            elasticDao.insertElasticItem(elasticItem)
        }
    }

    fun updateElastic(elasticItem: ElasticItem) {
        viewModelScope.launch {
            // Corrected to use updateElasticItem
            elasticDao.updateElasticItem(elasticItem)
        }
    }

    fun deleteElastic(elasticItem: ElasticItem) {
        viewModelScope.launch {
            // Corrected to use deleteElasticItem
            elasticDao.deleteElasticItem(elasticItem)
        }
    }

    // Optional: If you want to expose deleting by ID from ViewModel
    fun deleteElasticById(itemId: Int) {
        viewModelScope.launch {
            elasticDao.deleteElasticItemById(itemId)
        }
    }
}