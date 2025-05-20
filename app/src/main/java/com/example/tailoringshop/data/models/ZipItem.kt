package com.example.tailoringshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "zip_items")
data class ZipItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val type: String,
    val size: String,
    val color: String,
    val quantity: Int
)
