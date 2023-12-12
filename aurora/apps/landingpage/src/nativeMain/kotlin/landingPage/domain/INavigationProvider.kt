package landingPage.domain

import navigation.NavigationVM

internal interface INavigationProvider {
    fun getNavigation(): NavigationVM
}
