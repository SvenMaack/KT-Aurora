package landingPage.gateway

import arrow.core.Either
import arrow.core.raise.either
import css.base.EmptyDocument
import landingPage.domain.LandingPageProvider
import landingPage.domain.NavigationProvider
import page.*
import template.tags.enums.CountryCode
import template.tags.enums.GeneralLanguage
import kotlinx.coroutines.*
import landingPage.gateway.template.LandingPageDocument
import landingPage.gateway.template.LandingPageTemplate
import landingPage.server.HttpStatusCode

public interface Error {
    public val message: String
    public val errorCode: HttpStatusCode

    public data class NotFound(val id: String): Error {
        override val message: String = "The requested LandingPage is not found"
        override val errorCode: HttpStatusCode = HttpStatusCode.NotFound
    }

    public object NullId: Error {
        override val message: String = "An id of the LandingPage is needed"
        override val errorCode: HttpStatusCode = HttpStatusCode.InternalServerError
    }
}

internal object LandingPage {
    private val landingPage: IPage<LandingPageVM> = Page(
        name = "landingPage_$UniqueId",
        provider = IPageProvider.build(
            inlineCss = EmptyDocument,
            externalCss = LandingPageDocument,
            template = LandingPageTemplate
        ),
        debug = true
    )

    suspend fun getHtml(id: String?, currentUrl: String): Either<Error, String> =
        coroutineScope {
            either {
                if(id == null)
                    raise(Error.NullId)
                if(id == "invalid")
                    raise(Error.NotFound(id))

                val landingPageData = async { LandingPageProvider().getLandingPage(id) }
                val navigationData = async { NavigationProvider().getNavigation(currentUrl) }
                landingPage.getHtml(
                    PageContext(
                        GeneralLanguage.English,
                        CountryCode.UNITED_STATES
                    ),
                    LandingPageVM(
                        landingPage,
                        landingPageData.await(),
                        navigationData.await()
                    )
                )
            }
        }

    fun getExternalCss(): String =
        landingPage.getExternalCss()

    fun getExternalCssPath(): String =
        landingPage.getExternalCssPath()
}
