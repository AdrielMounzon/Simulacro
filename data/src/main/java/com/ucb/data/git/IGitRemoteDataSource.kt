package com.ucb.data.git

import com.ucb.domain.Gitalias
import com.ucb.data.NetworkResult

interface IGitRemoteDataSource {
    suspend fun fetch(userID: String): NetworkResult<Gitalias>
}