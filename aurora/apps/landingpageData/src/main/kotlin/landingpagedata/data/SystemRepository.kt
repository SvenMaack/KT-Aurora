package landingpagedata.data

import arrow.core.Either

internal interface SystemRepository {
    suspend fun hasKeyspace(): Either<DatabaseError, Boolean>
    suspend fun createKeySpace(): Either<DatabaseError, SystemRepository>
    suspend fun createTable(): Either<DatabaseError, SystemRepository>
}
