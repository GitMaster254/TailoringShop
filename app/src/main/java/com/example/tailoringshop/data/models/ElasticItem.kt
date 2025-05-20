package com.example.tailoringshop.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "elastic_items")
data class ElasticItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val size: String,
    val quantity: Int
)
