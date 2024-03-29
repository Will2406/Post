package com.android.post.data.repository

import com.android.post.data.datasource.user.UserLocalDataSource
import com.android.post.data.datasource.user.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remote: UserRemoteDataSource
) {

    suspend fun getAllUsers() = remote.getUsers()

}