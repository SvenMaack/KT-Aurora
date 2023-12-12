package landingPage.domain

import navigation.NavigationEntry
import navigation.NavigationVM

class NavigationProvider: INavigationProvider {
    override fun getNavigation(): NavigationVM {
        return NavigationVM(
            listOf(
                NavigationEntry("Home"),
                NavigationEntry("Trends", active = true),
                NavigationEntry("New Arrival"),
                NavigationEntry("Sales")
            )
        )
    }
}