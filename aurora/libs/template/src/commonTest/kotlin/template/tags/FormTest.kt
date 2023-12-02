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
    @Mock
    val blockTextArea = mock(classOf<Fun1<TextArea, Unit>>())
    @Mock
    val blockSelect = mock(classOf<Fun1<Select, Unit>>())
    @Mock
    val blockFieldset = mock(classOf<Fun1<Fieldset, Unit>>())

    @Test
    fun `tag name is form`() {
        val form = Form("id1")

        assertEquals("form", form.name)
        assertEquals("id1", form.id)
    }

    @Test
    fun `fieldSet function works`() {
        val form = Form("id1")
        every { blockFieldset.invoke(any()) }.returns(Unit)

        val fieldSet = form.fieldSet("a"["b"], name = "name1", disabled = true, clazz = "clazz", init = blockFieldset::invoke)

        verification(fieldSet, blockFieldset, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "disabled" to listOf(null),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `select function works without optionals`() {
        val form = Form("id1")
        every { blockFieldset.invoke(any()) }.returns(Unit)

        val fieldSet = form.fieldSet("a"["b"], name = "name1", disabled = false, init = blockFieldset::invoke)

        verification(fieldSet, blockFieldset, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
        ))
    }


    @Test
    fun `select function works`() {
        val form = Form("id1")
        every { blockSelect.invoke(any()) }.returns(Unit)

        val select = form.select("a"["b"], name = "name1", id = "id1", clazz = "clazz", init = blockSelect::invoke)

        verification(select, blockSelect, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "id" to listOf("id1"),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `select function works without class`() {
        val form = Form("id1")
        every { blockSelect.invoke(any()) }.returns(Unit)

        val select = form.select("a"["b"], name = "name1", id = "id1", init = blockSelect::invoke)

        verification(select, blockSelect, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "id" to listOf("id1")
        ))
    }

    @Test
    fun `select function works with all attributes`() {
        val form = Form("id1")
        every { blockSelect.invoke(any()) }.returns(Unit)

        val select = form.select(
            "a"["b"],
            clazz = "class1",
            id = "id1",
            autoFocus = true,
            disabled = true,
            multiple = true,
            required = true,
            name = "name1",
            size = 42,
            init = blockSelect::invoke
        )

        verification(select, blockSelect, mapOf(
            "a" to listOf("b"),
            "class" to listOf("class1"),
            "id" to listOf("id1"),
            "form" to listOf(form.id),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "multiple" to listOf(null),
            "required" to listOf(null),
            "name" to listOf("name1"),
            "size" to listOf("42"),
        ))
    }

    @Test
    fun `select function works with all attributes if one is null`() {
        val form = Form("id1")
        every { blockSelect.invoke(any()) }.returns(Unit)

        val select = form.select(
            "a"["b"],
            clazz = "class1",
            id = "id1",
            autoFocus = false, //<--
            disabled = false, //<--
            multiple = false, //<--
            required = false, //<--
            name = "name1",
            size = 42,
            init = blockSelect::invoke
        )

        verification(select, blockSelect, mapOf(
            "a" to listOf("b"),
            "class" to listOf("class1"),
            "id" to listOf("id1"),
            "form" to listOf(form.id),
            //"autofocus" to listOf(null),
            //"disabled" to listOf(null),
            //"multiple" to listOf(null),
            //"required" to listOf(null),
            "name" to listOf("name1"),
            "size" to listOf("42"),
        ))
    }

    @Test
    fun `textArea function works`() {
        val form = Form("id1")
        every { blockTextArea.invoke(any()) }.returns(Unit)

        val textArea = form.textArea("a"["b"], name = "name1", id = "id1", clazz = "clazz", init = blockTextArea::invoke)

        verification(textArea, blockTextArea, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "id" to listOf("id1"),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `textArea function works without class`() {
        val form = Form("id1")
        every { blockTextArea.invoke(any()) }.returns(Unit)

        val textArea = form.textArea("a"["b"], name = "name1", id = "id1", init = blockTextArea::invoke)

        verification(textArea, blockTextArea, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "id" to listOf("id1")
        ))
    }

    @Test
    fun `textArea function works with all attributes`() {
        val form = Form("id1")
        every { blockTextArea.invoke(any()) }.returns(Unit)

        val textArea = form.textArea(
            "a"["b"],
            clazz = "class1",
            id = "id1",
            autoFocus = true,
            cols = 41,
            rows = 42,
            dirName = true,
            disabled = true,
            wrap = Wrap.Soft,
            maxLength = 50,
            name = "name1",
            placeHolder = "ph",
            readOnly = true,
            required = true,
            init = blockTextArea::invoke
        )

        verification(textArea, blockTextArea, mapOf(
            "a" to listOf("b"),
            "class" to listOf("class1"),
            "id" to listOf("id1"),
            "form" to listOf(form.id),
            "autofocus" to listOf(null),
            "cols" to listOf("41"),
            "rows" to listOf("42"),
            "dirname" to listOf("name1.dir"),
            "disabled" to listOf(null),
            "wrap" to listOf(Wrap.Soft.value),
            "maxlength" to listOf("50"),
            "name" to listOf("name1"),
            "placeholder" to listOf("ph"),
            "readonly" to listOf(null),
            "required" to listOf(null),
        ))
    }

    @Test
    fun `textArea function works with all attributes if one is null`() {
        val form = Form("id1")
        every { blockTextArea.invoke(any()) }.returns(Unit)

        val textArea = form.textArea(
            "a"["b"],
            clazz = "class1",
            id = "id1",
            autoFocus = true,
            cols = 41,
            rows = 42,
            dirName = true,
            disabled = true,
            wrap = Wrap.Soft,
            maxLength = 50,
            name = "name1",
            placeHolder = null, //<--
            readOnly = true,
            required = true,
            init = blockTextArea::invoke
        )

        verification(textArea, blockTextArea, mapOf(
            "a" to listOf("b"),
            "class" to listOf("class1"),
            "id" to listOf("id1"),
            "form" to listOf(form.id),
            "autofocus" to listOf(null),
            "cols" to listOf("41"),
            "rows" to listOf("42"),
            "dirname" to listOf("name1.dir"),
            "disabled" to listOf(null),
            "wrap" to listOf(Wrap.Soft.value),
            "maxlength" to listOf("50"),
            "name" to listOf("name1"),
            //"placeholder" to listOf("ph"),
            "readonly" to listOf(null),
            "required" to listOf(null),
        ))
    }

    @Test
    fun `label function works`() {
        val form = Form("id1")
        val formElement = object : FormElement {
            override val id: String = "f1"
        }
        every { blockLabel.invoke(any()) }.returns(Unit)

        val label = form.label("a"["b"], `for` = formElement, clazz = "clazz", init = blockLabel::invoke)

        verification(label, blockLabel, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "for" to listOf("f1"),
            "class" to listOf("clazz")
        ))
    }

    @Test
    fun `label function works without class`() {
        val form = Form("id1")
        val formElement = object : FormElement {
            override val id: String = "f1"
        }
        every { blockLabel.invoke(any()) }.returns(Unit)

        val label = form.label("a"["b"], `for` = formElement, init = blockLabel::invoke)

        verification(label, blockLabel, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "for" to listOf("f1"),
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
