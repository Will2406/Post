package com.android.post.data.datasource.user

import com.android.post.data.api.PostService
import com.android.post.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val api: PostService
) : UserRemoteDataSource {

    override suspend fun getUsers(): Flow<List<UserResponse>> {
        return flow {
            val response = api.getUsers()
            if (response.isSuccessful) emit(response.body() ?: listOf())
        }
    }
}