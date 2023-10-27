package lib

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import lib.base.TagContainer
import lib.base.TransientTag

typealias DynamicTemplate<DTO> = (context: Context, data: DTO) -> TagContainer
typealias StaticTemplate = (context: Context) -> TagContainer

fun <DTO>TagContainer.include(context: Context, template: DynamicTemplate<DTO>, dto: DTO): TagContainer =
    add(template(context, dto))

fun TagContainer.include(context: Context, template: StaticTemplate): TagContainer =
    add(TransientTag().apply {
        val timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
        !"Cache start - $timestamp"
        +TemplateCache.getOrSet(context, template, TemplateRenderer::render)
        !"Cache end   - $timestamp"
    })

fun <T: TagContainer>T.childs(block: T.() -> Unit): TransientTag {
    block()
    return TransientTag().apply {
        this.addChildren(this@childs.children)
    }
}
