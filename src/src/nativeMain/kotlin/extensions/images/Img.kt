@file:Suppress("unused")

package extensions.images

import template_lib.base.Attribute
import template_lib.base.TagWithAttributes
import template_lib.base.get
import template_lib.tags.BodyTagContainer

enum class Loading(val value: String) {
    LAZY("lazy"),
    EAGER("eager")
}

class Img : TagWithAttributes("img")

fun BodyTagContainer.img(
    vararg attributes: Attribute,
    src: String,
    width: Int,
    height: Int,
    loading: Loading = Loading.LAZY,
    alt: String,
    clazz: String? = null)
= add(Img()) {
    if(clazz.isNullOrEmpty())
        setAttributes(*attributes, "src"[src], "width"[width.toString()], "height"[height.toString()], "loading"[loading.value], "alt"[alt])
    else
        setAttributes(*attributes, "src"[src], "width"[width.toString()], "height"[height.toString()], "loading"[loading.value], "alt"[alt], "class"[clazz])
}
