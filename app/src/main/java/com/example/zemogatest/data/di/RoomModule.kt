package com.example.zemogatest.data.di

import android.content.Context
import androidx.room.Room
import com.example.zemogatest.database.PostDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private val POST_DATABASE_NAME = "post_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            POST_DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun providePostDao(database: PostDatabase) =
        database.getPostDao()

}
