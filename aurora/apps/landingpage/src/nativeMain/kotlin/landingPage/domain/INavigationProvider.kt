package landingPage.domain

import navigation.NavigationVM

interface INavigationProvider {
    fun getNavigation(): NavigationVM
}