package landingpagedata

import arrow.core.raise.recover
import landingpagedata.data.DatabaseError
import kotlinx.coroutines.runBlocking

public fun main() {
    val appComponent = LandingPageComponent::class.create()
    runBlocking {
        recover(
            {
                appComponent.landingPage.init().bind()
                println("data" + appComponent.landingPage.get().bind())
            },
            { error: DatabaseError ->
                println("Error initializing landing page caused by: ${error.message}")
            }
        )
    }
    appComponent.connection().close()
}
