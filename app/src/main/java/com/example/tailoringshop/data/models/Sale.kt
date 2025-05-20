package com.example.tailoringshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales_table")
data class Sale(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val name: String,
    val size: String,
    val color: String,
    val quantity: Int,
    val price: Double,
    val timestamp: Long = System.currentTimeMillis() // For future filtering
)
