package com.android.post.domain.usecase

import com.android.post.data.repository.UserRepository
import com.android.post.domain.core.UseCase
import com.android.post.domain.model.UserModel
import com.android.post.domain.model.convertToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UserRepository
) : UseCase.WithoutParams<Flow<List<UserModel>>> {

    override suspend fun invoke(): Flow<List<UserModel>> {
        return repository.getAllUsers().map { it.convertToModel() }
    }
}