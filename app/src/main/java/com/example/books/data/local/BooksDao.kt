package com.example.books.data.local

import androidx.room.*
import com.example.books.data.local.entities.CachedBook
import com.example.books.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface BooksDao {
    @Query("SELECT * FROM ${Constants.ROOM.CACHED_BOOKS_TABLE} WHERE status=:status ORDER BY id ASC")
    fun getCachedBooks(
        status: Int
    ): Flow<List<CachedBook>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(
        book: CachedBook
    )

    @Query("DELETE FROM ${Constants.ROOM.CACHED_BOOKS_TABLE} WHERE id=:bookId")
    suspend fun removeBook(
        bookId: Int
    )
}
