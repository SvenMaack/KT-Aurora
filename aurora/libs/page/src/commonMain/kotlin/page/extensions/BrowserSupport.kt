package page_lib.page.extensions

import css_lib.base.DocumentList
import css_lib.visitors.BrowserVersionVisitor
import page_lib.page.base.IPageProvider
import template.Context
import template.base.TagContainer

class BrowserSupport<ViewModel>(private val inner: IPageProvider<ViewModel>): IPageProvider<ViewModel> by inner
{
    private val cachedSupport: Lazy<Map<String, Double>> = lazy {
        BrowserVersionVisitor().apply {
            DocumentList().apply {
                add(inner.getInlineCssDocument())
                add(inner.getExternalCssDocument())
            }.traverse(this)
        }.result
    }

    override fun getHtmlTag(context: Context, viewModel: ViewModel): TagContainer =
        inner.getHtmlTag(context, viewModel).apply {
            val newAttributes: MutableMap<String, List<String?>> = mutableMapOf()
            newAttributes.putAll(attributes)
            cachedSupport.value.forEach {
                newAttributes[it.key] = listOf(it.value.toString())
            }
            attributes = newAttributes
        }
}
