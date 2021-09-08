package com.example.books.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.books.models.Book
import com.example.books.utils.Constants

@Entity(tableName = Constants.ROOM.CACHED_BOOKS_TABLE)
data class CachedBook(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val status: Int,
    val book: Book
)
