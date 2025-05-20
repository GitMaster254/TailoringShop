package com.example.tailoringshop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
// Make sure these package names match your project structure
import com.example.tailoringshop.data.AppDatabase // Assuming AppDatabase is in this path
import com.example.tailoringshop.data.dao.ThreadDao    // Assuming ThreadDao is in this path
import com.example.tailoringshop.data.models.ThreadItem // Assuming ThreadItem is in this path
import kotlinx.coroutines.launch

class ThreadViewModel(application: Application) : AndroidViewModel(application) {

    // Ensure AppDatabase.getDatabase(application).threadDao() is correctly implemented
    // and that the package for AppDatabase is correct.
    private val threadDao: ThreadDao = AppDatabase.getDatabase(application).threadDao()

    // Corrected to use getAllThreadItems
    val allThreads: LiveData<List<ThreadItem>> = threadDao.getAllThreadItems()

    // Function to insert a new ThreadItem
    fun insertThread(threadItem: ThreadItem) {
        viewModelScope.launch {
            // Corrected to use insertThreadItem
            threadDao.insertThreadItem(threadItem)
        }
    }

    // Function to update an existing ThreadItem
    fun updateThread(threadItem: ThreadItem) {
        viewModelScope.launch {
            // Corrected to use updateThreadItem
            threadDao.updateThreadItem(threadItem)
        }
    }

    // Function to delete a ThreadItem
    fun deleteThread(threadItem: ThreadItem) {
        viewModelScope.launch {
            // Corrected to use deleteThreadItem
            threadDao.deleteThreadItem(threadItem)
        }
    }

    // Optional: If you want to expose deleting by ID from ViewModel
    fun deleteThreadById(itemId: Int) {
        viewModelScope.launch {
            threadDao.deleteThreadItemById(itemId)
        }
    }
}