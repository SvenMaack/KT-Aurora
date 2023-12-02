package template.tags

import io.mockative.*
import template.base.TagWithAttributes
import template.base.get
import template.tags.enums.EncType
import template.tags.enums.Method
import template.tags.enums.Target
import kotlin.test.Test
import kotlin.test.assertEquals

class FormTest {
    @Mock
    val blockButton = mock(classOf<Fun1<Button, Unit>>())
    @Mock
    val blockLabel = mock(classOf<Fun1<Label, Unit>>())

    @Test
    fun `tag name is form`() {
        val form = Form("id1")

        assertEquals("form", form.name)
        assertEquals("id1", form.id)
    }

    @Test
    fun `label function works`() {
        val form = Form("id1")
        every { blockLabel.invoke(any()) }.returns(Unit)

        val label = form.label("a"["b"], `for` = "foo", clazz = "clazz", init = blockLabel::invoke)

        verification(label, blockLabel, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "for" to listOf("foo"),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `label function works without class`() {
        val form = Form("id1")
        every { blockLabel.invoke(any()) }.returns(Unit)

        val label = form.label("a"["b"], `for` = "foo", init = blockLabel::invoke)

        verification(label, blockLabel, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "for" to listOf("foo"),
        ))
    }

    @Test
    fun `button function works`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.button("a"["b"], name = "name1", type = ButtonType.Button, clazz = "clazz", init = blockButton::invoke)

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "type" to listOf(ButtonType.Button.value),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `button function works without class`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.button("a"["b"], name = "name1", type = ButtonType.Button, init = blockButton::invoke)

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "type" to listOf(ButtonType.Button.value)
        ))
    }

    @Test
    fun `form function works with all attributes`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.button(
            "a"["b"],
            name = "name1",
            value = "value1",
            autoFocus = true,
            disabled = true,
            type = ButtonType.Button,
            init = blockButton::invoke
        )

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "value" to listOf("value1"),
            "type" to listOf(ButtonType.Button.value)
        ))
    }

    @Test
    fun `form function works with all attributes if one is null`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.button(
            "a"["b"],
            name = "name1",
            value = null, //<--
            autoFocus = true,
            disabled = true,
            type = ButtonType.Button,
            init = blockButton::invoke
        )

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            //"value" to listOf("value1"),
            "type" to listOf(ButtonType.Button.value)
        ))
    }

    @Test
    fun `submit function works`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.submit("a"["b"], name = "name1", clazz = "clazz", init = blockButton::invoke)

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "type" to listOf("submit"),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `submit function works without class`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.submit("a"["b"], name = "name1", init = blockButton::invoke)

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "type" to listOf("submit"),
        ))
    }

    @Test
    fun `submit function works with all attributes`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.submit(
            "a"["b"],
            clazz = "clazz",
            autoFocus = true,
            disabled = true,
            formAction = "formAction",
            formEnctype = EncType.Text_plain,
            formMethod = Method.GET,
            formNoValidate = true,
            formTarget = Target.BLANK,
            name = "name1",
            value = "value1",
            init = blockButton::invoke
        )

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "formaction" to listOf("formAction"),
            "formenctype" to listOf(EncType.Text_plain.value),
            "formmethod" to listOf(Method.GET.value),
            "formnovalidate" to listOf(null),
            "formtarget" to listOf(Target.BLANK.value),
            "name" to listOf("name1"),
            "value" to listOf("value1"),
            "form" to listOf(form.id),
            "type" to listOf("submit"),
        ))
    }

    @Test
    fun `submit function works with all attributes if some are false`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.submit(
            "a"["b"],
            clazz = "clazz",
            autoFocus = false, //<--
            disabled = false, //<--
            formAction = "formAction",
            formEnctype = EncType.Text_plain,
            formMethod = Method.GET,
            formNoValidate = false, //<--
            formTarget = Target.BLANK,
            name = "name1",
            value = null, //<--
            init = blockButton::invoke
        )

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "class" to listOf("clazz"),
            //"autofocus" to listOf(null),
            //"disabled" to listOf(null),
            "formaction" to listOf("formAction"),
            "formenctype" to listOf(EncType.Text_plain.value),
            "formmethod" to listOf(Method.GET.value),
            //"formnovalidate" to listOf(null),
            "formtarget" to listOf(Target.BLANK.value),
            "name" to listOf("name1"),
            //"value" to listOf("value"),
            "type" to listOf("submit"),
            "form" to listOf(form.id),
        ))
    }

    private fun <Tag: TagWithAttributes> verification(
        tag: Tag,
        callable: Fun1<Tag, Unit>,
        expectedMap: Map<String, List<String?>>
    ) {
        verify { callable.invoke(tag) }
            .wasInvoked(exactly = once)

        expectedMap.forEach { (key, value) ->
            assertEquals(value, tag.attributes[key], key)
        }
        assertEquals(expectedMap.keys.sorted(), tag.attributes.keys.sorted())
    }
}
