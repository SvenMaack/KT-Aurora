package page_lib.styling

import css_lib.base.Document
import css_lib.base.IDocument
import css_lib.base.Rule
import css_lib.base.RuleVisitor
import template_lib.base.*

class RemoveUnusedSelectors(private val element: Element): StylingRigger {
    override fun rig(document: IDocument): IDocument {
        val usedClass = GetClassTemplateVisitor().apply {
            element.traverse(this)
        }.result

        return DocumentFilterer(usedClass).apply {
            document.traverse(this)
        }.result
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
