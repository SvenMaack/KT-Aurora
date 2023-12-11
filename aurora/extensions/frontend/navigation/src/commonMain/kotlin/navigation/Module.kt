package navigation

import page.Module
import template.tags.BodyTagContainer

public val NavigationModule: Module<BodyTagContainer, NavigationVM> =
    Module(NavigationDocument, NavigationTemplate)
