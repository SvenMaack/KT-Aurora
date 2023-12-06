package template

import template.base.TagContainer

public typealias TemplateExtension<R, VM> = R.(context: Context, data: VM) -> Unit
public typealias StaticTemplateExtension<R> = TemplateExtension<R, Unit>

public inline fun <T: TagContainer, VM>T.include(context: Context, template: TemplateExtension<T, VM>, vm: VM) {
    template(context, vm)
}

public inline fun <T: TagContainer>T.include(context: Context, template: StaticTemplateExtension<T>) {
    include(context, template, Unit)
}
