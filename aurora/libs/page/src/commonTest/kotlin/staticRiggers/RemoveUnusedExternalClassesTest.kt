package page_lib.staticRiggers

import css_lib.base.Document
import css_lib.base.Property
import css_lib.base.RuleVisitor
import io.mockative.*
import page_lib.StaticPageRiggerData
import template_lib.base.Attribute
import template_lib.base.TagContainer
import template_lib.base.Visitor
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RemoveUnusedExternalClassesTest {
    @Mock
    val templateVisitor = mock(classOf<Visitor<String>>())
    @Mock
    val ruleVisitor = mock(classOf<RuleVisitor<String>>())

    @Test
    fun `test unused classe are removed`() {
        val tag = TagContainer("test").apply {
            setAttributes(object : Attribute {
                override val name: String = "class"
                override val value: String = "c1"
            })
        }
        val staticPageRiggerData = StaticPageRiggerData(
            Document().apply {
                this["c1"] = {+Property.build("p1", "v1")}
                this["c2"] = {+Property.build("p2", "v2")}
            },
            Document(),
            { templateVisitor },
            { ruleVisitor },
        )
        val removeUnusedExternalClasses = RemoveUnusedExternalClasses(tag)

        val changedStaticPageRiggerData = removeUnusedExternalClasses.change(staticPageRiggerData)

        assertEquals(1, (changedStaticPageRiggerData.externalDocument as Document).getRuleAmount())
        assertEquals(
            (staticPageRiggerData.externalDocument as Document).getRules()[0],
            (changedStaticPageRiggerData.externalDocument as Document).getRules()[0]
        )
    }
}
