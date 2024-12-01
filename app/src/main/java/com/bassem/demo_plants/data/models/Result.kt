package com.bassem.demo_plants.data.models



sealed class Result<T> {
    data object Loading : Result<Any?>()
    data class Success(val plantsList: List<Data>) : Result<Any?>()
    data class Fail(val reasons: String) : Result<Any?>()
}




