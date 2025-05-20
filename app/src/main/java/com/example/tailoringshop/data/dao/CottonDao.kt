package com.example.tailoringshop.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tailoringshop.data.models.CottonItem

@Dao
interface CottonDao {

    /**
     * Inserts a cotton item into the database.
     * If the item already exists, it will be replaced.
     * This operation is performed asynchronously.
     *
     * @param cottonItem The cotton item to insert.
     */
    @Insert
    suspend fun insertCottonItem(cottonItem: CottonItem)

    /**
     * Updates an existing cotton item in the database.
     * This operation is performed asynchronously.
     *
     * @param cottonItem The cotton item to update.
     */
    @Update
    suspend fun updateCottonItem(cottonItem: CottonItem)

    /**
     * Deletes a specific cotton item from the database.
     * This operation is performed asynchronously.
     *
     * @param cottonItem The cotton item to delete.
     */
    @Delete
    suspend fun deleteCottonItem(cottonItem: CottonItem)

    /**
     * Deletes a cotton item from the database by its ID.
     * This operation is performed asynchronously.
     *
     * @param itemId The ID of the cotton item to delete.
     */
    @Query("DELETE FROM cotton_items WHERE id = :itemId")
    suspend fun deleteCottonItemById(itemId: Int)

    /**
     * Retrieves all cotton items from the database, ordered by their ID in ascending order.
     * Returns the list as LiveData, which allows observing changes to the data.
     *
     * @return LiveData holding a list of all cotton items.
     */
    @Query("SELECT * FROM cotton_items ORDER BY id ASC")
    fun getAllCottonItems(): LiveData<List<CottonItem>>

    /**
     * Retrieves a specific cotton item from the database by its ID.
     * This operation is performed asynchronously.
     *
     * @param itemId The ID of the cotton item to retrieve.
     * @return The CottonItem if found, otherwise null.
     */
    @Query("SELECT * FROM cotton_items WHERE id = :itemId")
    suspend fun getCottonItemById(itemId: Int): CottonItem?
}