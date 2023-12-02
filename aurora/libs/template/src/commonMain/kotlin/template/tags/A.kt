package template.tags

import template.base.Attribute
import template.base.TagContainer
import template.base.get
import template.tags.enums.Language
import template.tags.enums.MediaType
import template.tags.enums.ReferrerPolicy
import template.tags.enums.Rel
import template.tags.enums.Target

/**
 * The a-tag defines a hyperlink, which is used to link from one page to another.
 */
public class A: BodyTagContainer("a") {
    @PublishedApi
    @Suppress("LongParameterList", "SpreadOperator")
    internal companion object {
        inline fun <T: TagContainer> addATagWithAttributes(
            parent: T,
            href: String,
            type: MediaType? = null,
            download: Boolean = false,
            target: Target? = null,
            clazz: String? = null,
            hrefLang: Language? = null,
            referrerPolicy: ReferrerPolicy? = null,
            rel: Rel? = null,
            pings: List<String> = listOf(),
            vararg attributes: Attribute): A = parent.add(A())
        {
            setAttributes(
                *attributes,
                "href"[href],
                *AttributeFilter.filterTrue(
                    BoolAttribute("download", download),
                ),
                *AttributeFilter.filterNotNull(
                    "type"[type?.value],
                    "target"[target?.value],
                    "class"[clazz],
                    "hreflang"[hrefLang?.value],
                    "referrerpolicy"[referrerPolicy?.value],
                    "rel"[rel?.value],
                    if(pings.isEmpty())
                        "ping"[null]
                    else
                        "ping"[pings.joinToString(" ")],
                )
            )
        }
    }
}
