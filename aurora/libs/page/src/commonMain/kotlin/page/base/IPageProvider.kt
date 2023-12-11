package page.base

import css.base.IDocument
import template.Context
import template.base.TagContainer

public interface InlineCssProvider {
    public fun getInlineCssDocument(): IDocument
}
public interface ExternalCssProvider {
    public fun getExternalCssDocument(): IDocument
}
public interface CssProvider: InlineCssProvider, ExternalCssProvider

public interface HtmlProvider<ViewModel> {
    public fun getHtmlTag(context: Context, viewModel: ViewModel): TagContainer
}

public interface IPageProvider<ViewModel>: HtmlProvider<ViewModel>, CssProvider
