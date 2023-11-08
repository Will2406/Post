package com.android.post.domain.usecase

import com.android.post.data.repository.PostRepository
import com.android.post.domain.core.UseCase
import com.android.post.domain.model.PostModel
import com.android.post.domain.model.convertToModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPostsByUserUseCase @Inject constructor(
    private val repository: PostRepository
) : UseCase.WithParams<Int, Flow<List<PostModel>>> {

    override suspend fun invoke(params: Int): Flow<List<PostModel>> {
        return repository.getPostByUser(params).map { it.convertToModel() }
    }
}