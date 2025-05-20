package com.example.tailoringshop.data.dao

import androidx.lifecycle.LiveData // Import LiveData
import androidx.room.Dao
import androidx.room.Delete // Import Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tailoringshop.data.models.OtherItem

@Dao
interface OtherDao {

    /**
     * Inserts an "other" item into the database.
     */
    @Insert
    suspend fun insertOtherItem(otherItem: OtherItem)

    /**
     * Updates an existing "other" item in the database.
     */
    @Update
    suspend fun updateOtherItem(otherItem: OtherItem)

    /**
     * Deletes a specific "other" item from the database.
     */
    @Delete
    suspend fun deleteOtherItem(otherItem: OtherItem) // Added delete operation

    /**
     * Deletes an "other" item from the database by its ID.
     */
    @Query("DELETE FROM other_items WHERE id = :itemId") // Assuming 'id' is the primary key
    suspend fun deleteOtherItemById(itemId: Int) // Added specific delete by ID

    /**
     * Retrieves all "other" items from the database, ordered by their ID.
     * Returns the list as LiveData for observing changes.
     */
    @Query("SELECT * FROM other_items ORDER BY id ASC") // Assuming 'id' and ordering
    fun getAllOtherItems(): LiveData<List<OtherItem>> // Changed to LiveData, removed suspend

    /**
     * Retrieves a specific "other" item from the database by its ID.
     * @return The OtherItem if found, otherwise null.
     */
    @Query("SELECT * FROM other_items WHERE id = :itemId") // Assuming 'id'
    suspend fun getOtherItemById(itemId: Int): OtherItem?
}