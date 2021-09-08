package com.example.books.data

import com.example.books.data.local.BooksDao
import com.example.books.data.local.entities.CachedBook
import com.example.books.utils.Constants
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: BooksDao
) {
    fun getReading(): Flow<List<CachedBook>> {
        return recipesDao.getCachedBooks(Constants.STATUS.READING)
    }

    fun getCompleted(): Flow<List<CachedBook>> {
        return recipesDao.getCachedBooks(Constants.STATUS.COMPLETED)
    }

    // ***

    suspend fun insertBook(book: CachedBook) {
        recipesDao.insertBook(book)
    }

    suspend fun removeBook(bookId: Int) {
        recipesDao.removeBook(bookId)
    }
}
