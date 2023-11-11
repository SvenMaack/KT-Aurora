package page_lib.staticRiggers

import css_lib.base.*
import page_lib.StaticPageRiggerData
import page_lib.StaticPageRigger
import template_lib.base.*

class RemoveUnusedExternalClasses(private val element: Element): StaticPageRigger {
    override fun change(data: StaticPageRiggerData): StaticPageRiggerData {
        val usedClass = GetClassTemplateVisitor().apply {
            element.traverse(this)
        }.result

        return data.copy(
            externalDocument = DocumentFilterer(usedClass).apply {
                data.externalDocument.traverse(this)
            }.result
        )
    }
}

private class DocumentFilterer(private val allowedClass: List<String>): RuleVisitor<IDocument> {
    override val result: Document = Document()

    override fun visitRule(rule: Rule): RuleVisitor<IDocument> {
        if(allowedClass.contains(rule.getClass())) {
            result.set(rule)
        }
        return this
    }
}

private class GetClassTemplateVisitor : Visitor<List<String>> {
    override val result: MutableList<String> = mutableListOf()

    override fun visitTag(tag: Tag) {
        //silence is golden
    }

    override fun visitTagWithAttributes(tag: TagWithAttributes) {
        tag.attributes.filter { it.key == "class" }.forEach {
            result.addAll(it.value)
        }
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        visitTagWithAttributes(tagContainer)
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        //silence is golden
    }

    override fun visitTextElement(element: TextElement) {
        //silence is golden
    }

    override fun visitComment(comment: Comment) {
        //silence is golden
    }
}
