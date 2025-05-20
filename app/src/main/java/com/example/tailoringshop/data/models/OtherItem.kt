package com.example.tailoringshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "other_items")
data class OtherItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val quantity: Int
)
