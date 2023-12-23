package landingpagedata

import landingpagedata.data.LandingPage
import landingpagedata.data.PersistedLandingPage
import landingpagedata.data.db.CassandraConnection
import landingpagedata.data.DatabaseConnection
import landingpagedata.data.Repository
import landingpagedata.data.db.LandingPageRepository
import landingpagedata.data.SystemRepository
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

@Component
internal abstract class LandingPageComponent {
    abstract val landingPage: LandingPage

    protected val PersistedLandingPage.bind: LandingPage
        @Provides get() = this

    @Provides
    fun connection(): DatabaseConnection =
        CassandraConnection

    @Provides
    protected fun repository(repository: LandingPageRepository): Repository = repository

    @Provides
    protected fun systemRepository(repository: LandingPageRepository): SystemRepository = repository
}
