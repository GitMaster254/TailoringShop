package com.example.tailoringshop.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tailoringshop.data.dao.ElasticDao
import com.example.tailoringshop.data.dao.CottonDao
import com.example.tailoringshop.data.dao.OtherDao
import com.example.tailoringshop.data.dao.SaleDao
import com.example.tailoringshop.data.dao.ThreadDao
import com.example.tailoringshop.data.dao.ZipDao
import com.example.tailoringshop.data.models.ElasticItem
import com.example.tailoringshop.data.models.CottonItem
import com.example.tailoringshop.data.models.OtherItem
import com.example.tailoringshop.data.models.ThreadItem
import com.example.tailoringshop.data.models.ZipItem
import com.example.tailoringshop.data.models.Sale

@Database(
    entities = [ThreadItem::class, ZipItem::class, CottonItem::class,
        ElasticItem::class, OtherItem::class, Sale::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun threadDao(): ThreadDao
    abstract fun zipDao(): ZipDao
    abstract fun cottonDao(): CottonDao
    abstract fun elasticDao(): ElasticDao
    abstract fun otherDao(): OtherDao
    abstract fun saleDao(): SaleDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "tailoring_shop"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
