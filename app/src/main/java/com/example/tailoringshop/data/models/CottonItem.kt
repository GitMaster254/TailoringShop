package com.example.tailoringshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cotton_items")
data class CottonItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val color: String,
    val quantity: Int
)
