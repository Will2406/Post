package com.android.post.data.di

import com.android.post.data.api.PostService
import com.android.post.data.datasource.post.PostRemoteDataSource
import com.android.post.data.datasource.post.PostRemoteDataSourceImpl
import com.android.post.data.datasource.user.UserRemoteDataSource
import com.android.post.data.datasource.user.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun createUserRemoteDataSource(api: PostService): UserRemoteDataSource = UserRemoteDataSourceImpl(api)

    @Provides
    fun createPostRemoteDataSource(api: PostService): PostRemoteDataSource = PostRemoteDataSourceImpl(api)

}