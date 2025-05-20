package com.example.tailoringshop.data.dao

import androidx.lifecycle.LiveData // Import LiveData
import androidx.room.Dao
import androidx.room.Delete // Import Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tailoringshop.data.models.ThreadItem

@Dao
interface ThreadDao {

    /**
     * Inserts a thread item into the database.
     */
    @Insert
    suspend fun insertThreadItem(threadItem: ThreadItem)

    /**
     * Updates an existing thread item in the database.
     */
    @Update
    suspend fun updateThreadItem(threadItem: ThreadItem)

    /**
     * Deletes a specific thread item from the database.
     */
    @Delete
    suspend fun deleteThreadItem(threadItem: ThreadItem) // Added delete operation

    /**
     * Deletes a thread item from the database by its ID.
     */
    @Query("DELETE FROM thread_items WHERE id = :itemId") // Assuming 'id' is the primary key
    suspend fun deleteThreadItemById(itemId: Int) // Added specific delete by ID

    /**
     * Retrieves all thread items from the database, ordered by their ID.
     * Returns the list as LiveData for observing changes.
     */
    @Query("SELECT * FROM thread_items ORDER BY id ASC") // Assuming 'id' and ordering
    fun getAllThreadItems(): LiveData<List<ThreadItem>> // Changed to LiveData, removed suspend

    /**
     * Retrieves a specific thread item from the database by its ID.
     * @return The ThreadItem if found, otherwise null.
     */
    @Query("SELECT * FROM thread_items WHERE id = :itemId") // Assuming 'id'
    suspend fun getThreadItemById(itemId: Int): ThreadItem?
}