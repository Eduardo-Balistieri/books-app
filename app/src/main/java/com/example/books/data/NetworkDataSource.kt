package com.example.books.data

import com.example.books.data.network.ItunesService
import com.example.books.models.Book
import com.example.books.models.NetworkResult
import javax.inject.Inject

class NetworkDataSource @Inject constructor (
    private val itunesService: ItunesService
) {
    suspend fun searchForBooks(term: String): NetworkResult<List<Book>> {
        try {
            val response = itunesService.searchForBooks(term)

            return when {
                response.body()!!.results.isNullOrEmpty() -> {
                    NetworkResult.Failure("Not found")
                }
                response.isSuccessful -> {
                    val booksList = response.body()!!.results
                    NetworkResult.Success(booksList)
                }
                else -> NetworkResult.Failure(response.message())
            }
        }
        catch (exception: Exception) {
            return NetworkResult.Failure(exception.message)
        }
    }
}
