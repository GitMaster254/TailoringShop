package com.example.tailoringshop.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tailoringshop.data.models.Sale

@Dao
interface SaleDao {
    @Insert
    suspend fun insertSale(sale: Sale)

    @Query("SELECT * FROM sales ORDER BY timestamp DESC")
    suspend fun getAllSales(): List<Sale>
}
