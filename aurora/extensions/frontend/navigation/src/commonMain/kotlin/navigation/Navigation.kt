@file:Suppress("WrapUnaryOperator")
package navigation

import page.ClassGenerator
import template.tags.BodyTagContainer
import template.base.*

internal val NAVIGATION: String = ClassGenerator()
internal val NAVIGATION__ITEM: String = ClassGenerator()
internal val NAVIGATION__ITEM__ACTIVE: String = ClassGenerator()

public fun BodyTagContainer._navigation(vm: NavigationVM) {
    nav {
        ul("role"["list"], clazz=NAVIGATION) {
            vm.entries.forEach {
                li("class"[NAVIGATION__ITEM, NAVIGATION__ITEM__ACTIVE%it.active]) {
                    a("role"["cta"], href="#") {
                        span {
                            +it.name
                        }
                    }
                }
            }
        }
    }
}
