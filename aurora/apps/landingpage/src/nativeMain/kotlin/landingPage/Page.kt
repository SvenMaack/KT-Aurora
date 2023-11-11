package landingPage

import landingPage.module.LandingPageModule
import page_lib.*

val landingPage = PageBuilder(
    name = "page",
    externalDocument = LandingPageModule.document,
    runtimeModifier = BrowserSupport+StylingCache
).build()