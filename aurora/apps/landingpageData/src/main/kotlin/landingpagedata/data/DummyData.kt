package landingpagedata.data

private const val PAGE_1 = 1

internal val dummyData: List<NavigationEntry> = listOf(
    object : NavigationEntry {
        override val page = PAGE_1
        override val title = "Home"
        override val language = "en"
        override val url = "/"
    },
    object : NavigationEntry {
        override val page = PAGE_1
        override val title = "Home"
        override val language = "de"
        override val url = "/"
    },
    object : NavigationEntry {
        override val page = PAGE_1
        override val title = "About"
        override val language = "en"
        override val url = "/about"
    },
     object : NavigationEntry {
         override val page = PAGE_1
        override val title = "About"
        override val language = "de"
        override val url = "/ueber"
     },
    object : NavigationEntry {
        override val page = PAGE_1
        override val title = "Contact"
        override val language = "en"
        override val url = "/contact"
    },
    object : NavigationEntry {
        override val page = PAGE_1
        override val title = "Contact"
        override val language = "de"
        override val url = "/kontakt"
    },
)
