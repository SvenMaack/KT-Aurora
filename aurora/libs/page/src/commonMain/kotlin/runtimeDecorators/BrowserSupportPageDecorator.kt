package page_lib.runtimeDecorators

import css_lib.base.DocumentList
import css_lib.visitors.BrowserVersionVisitor
import page_lib.IPage
import template_lib.Context
import template_lib.base.TagContainer

class BrowserSupportPageDecorator(private val inner: IPage): IPage by inner  {
    private val cachedSupport: Lazy<Map<String, Double>> = lazy {
        BrowserVersionVisitor().apply {
            DocumentList().apply {
                add(internalDocument)
                add(externalDocument)
            }.traverse(this)
        }.result
    }

    override fun getHtml(context: Context, tag: TagContainer): String {
        tag.apply {
            val newAttributes: MutableMap<String, List<String>> = mutableMapOf()
            newAttributes.putAll(attributes)
            cachedSupport.value.forEach {
                newAttributes[it.key] = listOf(it.value.toString())
            }
            attributes = newAttributes
        }
        return inner.getHtml(context, tag)
    }
}
