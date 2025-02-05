package com.vzh.docspaceportal.domain.common

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Error<T>(data: T? = null, message: String?) : Result<T>(data, message)
    class Success<T>(data: T) : Result<T>(data)

    inline fun <R> map(transform: (T) -> R): Result<R> {
        return when (this) {
            is Success -> Success(transform(data!!))
            is Error -> Error(null, message)
        }
    }
}
