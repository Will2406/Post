package com.android.post.data.datasource.user

import com.android.post.data.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRemoteDataSource {
    suspend fun getUsers(): Flow<List<UserResponse>>
}

interface UserLocalDataSource {

}