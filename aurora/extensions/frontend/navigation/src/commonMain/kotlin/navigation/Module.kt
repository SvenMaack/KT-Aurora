package navigation

import page_lib.Module
import template.tags.BodyTagContainer

public val NavigationModule: Module<BodyTagContainer, NavigationVM> =
    Module(NavigationDocument, NavigationTemplate)
