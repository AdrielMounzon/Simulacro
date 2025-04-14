package com.ucb.usecases

import com.ucb.data.GithubRepository
import com.ucb.data.NetworkResult
import com.ucb.domain.Gitalias
import kotlinx.coroutines.delay

class FindGitAlias(
    val githubRepository: GithubRepository
) {
    suspend fun invoke(userId: String) : NetworkResult<Gitalias> {
        return githubRepository.findbyId(userId)
    }
}