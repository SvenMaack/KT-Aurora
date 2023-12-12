package landingPage.gateway

import head.SeoVM
import landingPage.domain.Navigation
import landingPage.domain.Seo
import navigation.NavigationEntryVM
import navigation.NavigationVM

internal fun Navigation.toNavigationVM(): NavigationVM {
    val navigation = this
    return object: NavigationVM {
        override val entries: List<NavigationEntryVM> = navigation.entries.map { entry ->
            object : NavigationEntryVM {
                override val name = entry.name
                override val active = entry.active
            }
        }
    }
}

internal fun Seo.toSeoVM(): SeoVM {
    val seo = this
    return object: SeoVM {
        override val canonicalUrl: String = seo.canonicalUrl
        override val description: String = seo.description
        override val keywords: String = seo.keywords
        override val title: String = seo.title
    }
}
