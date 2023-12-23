package landingpagedata.data

import arrow.core.Either

internal interface LandingPage {
    suspend fun init(): Either<DatabaseError, Unit>
    suspend fun get(): Either<DatabaseError, List<NavigationEntry>>
}
