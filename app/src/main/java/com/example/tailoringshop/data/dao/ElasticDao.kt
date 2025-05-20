package com.example.tailoringshop.data.dao

import androidx.lifecycle.LiveData // Import LiveData
import androidx.room.Dao
import androidx.room.Delete // Import Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tailoringshop.data.models.ElasticItem

@Dao
interface ElasticDao {

    /**
     * Inserts an elastic item into the database.
     * This operation is performed asynchronously.
     */
    @Insert
    suspend fun insertElasticItem(elasticItem: ElasticItem)

    /**
     * Updates an existing elastic item in the database.
     * This operation is performed asynchronously.
     */
    @Update
    suspend fun updateElasticItem(elasticItem: ElasticItem)

    /**
     * Deletes a specific elastic item from the database.
     * This operation is performed asynchronously.
     */
    @Delete
    suspend fun deleteElasticItem(elasticItem: ElasticItem) // Added delete operation

    /**
     * Deletes an elastic item from the database by its ID.
     * This operation is performed asynchronously.
     */
    @Query("DELETE FROM elastic_items WHERE id = :itemId") // Assuming 'id' is the primary key
    suspend fun deleteElasticItemById(itemId: Int) // Added specific delete by ID

    /**
     * Retrieves all elastic items from the database, ordered by their ID.
     * Returns the list as LiveData for observing changes.
     */
    @Query("SELECT * FROM elastic_items ORDER BY id ASC") // Assuming 'id' and ordering
    fun getAllElasticItems(): LiveData<List<ElasticItem>> // Changed to LiveData, removed suspend

    /**
     * Retrieves a specific elastic item from the database by its ID.
     * This operation is performed asynchronously.
     * @return The ElasticItem if found, otherwise null.
     */
    @Query("SELECT * FROM elastic_items WHERE id = :itemId") // Assuming 'id'
    suspend fun getElasticItemById(itemId: Int): ElasticItem?
}