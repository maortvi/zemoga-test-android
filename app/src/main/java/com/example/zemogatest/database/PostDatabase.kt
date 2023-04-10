package com.example.zemogatest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zemogatest.database.dao.PostDao
import com.example.zemogatest.database.entity.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1
)
abstract class PostDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostDao

}
