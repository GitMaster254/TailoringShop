package com.example.tailoringshop.data.dao

import androidx.lifecycle.LiveData // Import LiveData
import androidx.room.Dao
import androidx.room.Delete // Import Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tailoringshop.data.models.ZipItem

@Dao
interface ZipDao {

    /**
     * Inserts a zip item into the database.
     */
    @Insert
    suspend fun insertZipItem(zipItem: ZipItem)

    /**
     * Updates an existing zip item in the database.
     */
    @Update
    suspend fun updateZipItem(zipItem: ZipItem)

    /**
     * Deletes a specific zip item from the database.
     */
    @Delete
    suspend fun deleteZipItem(zipItem: ZipItem) // Added delete operation

    /**
     * Deletes a zip item from the database by its ID.
     */
    @Query("DELETE FROM zip_items WHERE id = :itemId") // Assuming 'id' is the primary key
    suspend fun deleteZipItemById(itemId: Int) // Added specific delete by ID

    /**
     * Retrieves all zip items from the database, ordered by their ID.
     * Returns the list as LiveData for observing changes.
     */
    @Query("SELECT * FROM zip_items ORDER BY id ASC") // Assuming 'id' and ordering
    fun getAllZipItems(): LiveData<List<ZipItem>> // Changed to LiveData, removed suspend

    /**
     * Retrieves a specific zip item from the database by its ID.
     * @return The ZipItem if found, otherwise null.
     */
    @Query("SELECT * FROM zip_items WHERE id = :itemId") // Assuming 'id'
    suspend fun getZipItemById(itemId: Int): ZipItem?
}