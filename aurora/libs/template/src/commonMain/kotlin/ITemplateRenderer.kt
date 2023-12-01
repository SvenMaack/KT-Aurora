package template_lib

import template_lib.base.Element

public interface ITemplateRenderer {
    public fun render(context: Context, template: Template<Unit>): String

    public fun <VM>render(context: Context, template: Template<VM>, vm: VM): String

    public fun render(context: Context, element: Element): String
}
