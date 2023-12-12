package landingPage.gateway

import head.TechnicalData
import navigation.NavigationVM

data class LandingPageVM(
    val technicalData: TechnicalData,
    val navigation: NavigationVM
)
