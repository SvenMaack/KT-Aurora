package page.extensions

import css.base.DocumentList
import css.visitors.BrowserVersionVisitor
import page.IPageProvider
import template.Template
import template.base.TemplatingApi
import template.base.TransientTag

public class BrowserSupport<ViewModel>(private val inner: IPageProvider<ViewModel>): IPageProvider<ViewModel> by inner
{
    private val cachedSupport: Lazy<Map<String, Double>> = lazy {
        BrowserVersionVisitor().apply {
            DocumentList().apply {
                +inner.getInlineCssDocument()
                +inner.getExternalCssDocument()
            }.traverse(this)
        }.result
    }

    @OptIn(TemplatingApi::class)
    override fun getTemplate(): Template<ViewModel> =
        { context, model ->
            TransientTag().apply {
                !cachedSupport.toString()
                add(inner.getTemplate()(context, model))
            }
        }
}
