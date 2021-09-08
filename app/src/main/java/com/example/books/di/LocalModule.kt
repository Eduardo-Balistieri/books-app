package com.example.books.di

import android.content.Context
import androidx.room.Room
import com.example.books.data.local.BooksDao
import com.example.books.data.local.BooksDatabase
import com.example.books.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): BooksDatabase {
        return Room.databaseBuilder(
            context,
            BooksDatabase::class.java,
            Constants.ROOM.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(
        database: BooksDatabase
    ): BooksDao {
        return database.booksDao()
    }
}
