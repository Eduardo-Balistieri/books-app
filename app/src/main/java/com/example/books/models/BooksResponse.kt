package com.example.books.models


import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Book>
)
