package com.example.tailoringshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "thread_items")
data class ThreadItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val size: String,
    val color: String,
    val quantity: Int
)
