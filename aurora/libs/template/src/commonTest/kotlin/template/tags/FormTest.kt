package template.tags

import io.mockative.*
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import template.base.TagWithAttributes
import template.base.get
import template.tags.enums.AutoComplete
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
    @Mock
    val blockInput= mock(classOf<Fun1<Input, Unit>>())

    @Test
    fun `tag name is form`() {
        val form = Form("id1")

        assertEquals("form", form.name)
        assertEquals("id1", form.id)
    }

    //<editor-fold desc="button">
    @Test
    fun `button function works`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.button("a"["b"], name = "name1", type = ButtonType.Button, init = blockButton::invoke)

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "type" to listOf(ButtonType.Button.value),
        ))
    }

    @Test
    fun `button function works with all attributes`() {
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
    //</editor-fold>

    //<editor-fold desc="submit">
    @Test
    fun `submit function works`() {
        val form = Form("id1")
        every { blockButton.invoke(any()) }.returns(Unit)

        val button = form.submit("a"["b"], name = "name1", formAction = "fa", init = blockButton::invoke)

        verification(button, blockButton, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "type" to listOf("submit"),
            "formaction" to listOf("fa"),
            "formenctype" to listOf(EncType.APPLICATION_X_WWW_FORM_URLENCODED.value),
            "formmethod" to listOf(Method.POST.value),
            "formtarget" to listOf(Target.SELF.value),
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
            formEnctype = EncType.TEXT_PLAIN,
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
            "formenctype" to listOf(EncType.TEXT_PLAIN.value),
            "formmethod" to listOf(Method.GET.value),
            "formnovalidate" to listOf(null),
            "formtarget" to listOf(Target.BLANK.value),
            "name" to listOf("name1"),
            "value" to listOf("value1"),
            "form" to listOf(form.id),
            "type" to listOf("submit"),
        ))
    }
    //</editor-fold>

    //<editor-fold desc="input">
    @Test
    fun `inputFile function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputFile(
            "a"["b"],
            name = "name1",
            accept = AcceptByType.AUDIO,
            value="v1",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("file"),
            "name" to listOf("name1"),
            "value" to listOf("v1"),
            "accept" to listOf(AcceptByType.AUDIO.value),
        ))
    }

    @Test
    fun `inputFile function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputFile(
            "a"["b"],
            name = "name1",
            value="v1",
            accept = AcceptByType.IMAGE,
            autoFocus = true,
            disabled = true,
            multiple = true,
            required = true,
            clazz = "clazz",
            defaultValue = "dv",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("v1"),
            "type" to listOf("file"),
            "accept" to listOf(AcceptByType.IMAGE.value),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "multiple" to listOf(null),
            "required" to listOf(null),
            "class" to listOf("clazz"),
            "defaultValue" to listOf("dv"),
        ))
    }

    @Test
    fun `inputCheckbox function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputCheckbox(
            "a"["b"],
            name = "name1",
            value="v1",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("checkbox"),
            "name" to listOf("name1"),
            "value" to listOf("v1"),
        ))
    }

    @Test
    fun `inputCheckbox function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputCheckbox(
            "a"["b"],
            name = "name1",
            value="v1",
            autoFocus = true,
            disabled = true,
            required = true,
            indeterminate = true,
            clazz = "clazz",
            defaultValue = "dv",
            defaultChecked = "dv1",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("v1"),
            "type" to listOf("checkbox"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "required" to listOf(null),
            "indeterminate" to listOf("true"),
            "class" to listOf("clazz"),
            "defaultValue" to listOf("dv"),
            "defaultChecked" to listOf("dv1"),
        ))
    }

    @Test
    fun `inputColor function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputColor(
            "a"["b"],
            name = "name1",
            value="v1",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("color"),
            "name" to listOf("name1"),
            "value" to listOf("v1"),
        ))
    }

    @Test
    fun `inputColor function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputColor(
            "a"["b"],
            name = "name1",
            value="v1",
            autoFocus = true,
            disabled = true,
            autoComplete = "a",
            clazz = "clazz",
            defaultValue = "dv",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("v1"),
            "type" to listOf("color"),
            "autofocus" to listOf(null),
            "autocomplete" to listOf("a"),
            "disabled" to listOf(null),
            "class" to listOf("clazz"),
            "defaultValue" to listOf("dv"),
        ))
    }

    @Test
    fun `inputDate function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputDate(
            "a"["b"],
            name = "name1",
            value = LocalDate.parse("2022-01-06"),
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("date"),
            "name" to listOf("name1"),
            "value" to listOf("2022-01-06"),
        ))
    }

    @Test
    fun `inputDate function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputDate(
            "a"["b"],
            name = "name1",
            value= LocalDate.parse("2022-01-06"),
            autoComplete = "ac",
            autoFocus = true,
            readOnly = true,
            defaultValue = "dv",
            disabled = true,
            required = true,
            max = LocalDate.parse("2022-02-06"),
            min = LocalDate.parse("2022-03-06"),
            step = 42,
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("2022-01-06"),
            "type" to listOf("date"),
            "autofocus" to listOf(null),
            "autocomplete" to listOf("ac"),
            "readOnly" to listOf(null),
            "defaultValue" to listOf("dv"),
            "disabled" to listOf(null),
            "required" to listOf(null),
            "max" to listOf("2022-02-06"),
            "min" to listOf("2022-03-06"),
            "step" to listOf("42"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputEmail function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputEmail(
            "a"["b"],
            name = "name1",
            value = "em",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("email"),
            "name" to listOf("name1"),
            "value" to listOf("em"),
        ))
    }

    @Test
    fun `inputEmail function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputEmail(
            "a"["b"],
            name = "name1",
            value= "em",
            defaultValue = "dv",
            autoComplete = "ac",
            autoFocus = true,
            readOnly = true,
            disabled = true,
            required = true,
            multiple = true,
            maxLength = 42,
            pattern = "p",
            placeHolder = "ph",
            clazz = "clazz",
            size = 43,
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("em"),
            "type" to listOf("email"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "readOnly" to listOf(null),
            "disabled" to listOf(null),
            "required" to listOf(null),
            "multiple" to listOf(null),
            "maxLength" to listOf("42"),
            "pattern" to listOf("p"),
            "placeholder" to listOf("ph"),
            "class" to listOf("clazz"),
            "size" to listOf("43"),
        ))
    }

    @Test
    fun `inputHidden function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputHidden(
            "a"["b"],
            name = "name1",
            value = "em",
            defaultValue = "dv",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("hidden"),
            "name" to listOf("name1"),
            "value" to listOf("em"),
            "defaultValue" to listOf("dv"),
        ))
    }

    @Test
    fun `inputMonth function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputMonth(
            "a"["b"],
            name = "name1",
            value = LocalDate.parse("2022-01-06"),
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("month"),
            "name" to listOf("name1"),
            "value" to listOf("2022-01"),
        ))
    }

    @Test
    fun `inputMonth function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputMonth(
            "a"["b"],
            name = "name1",
            value = LocalDate.parse("2022-01-06"),
            defaultValue = "dv",
            autoComplete = "ac",
            autoFocus = true,
            readOnly = true,
            disabled = true,
            required = true,
            min = LocalDate.parse("2022-02-06"),
            max = LocalDate.parse("2022-03-06"),
            clazz = "clazz",
            step = 43,
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("2022-01"),
            "type" to listOf("month"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "readOnly" to listOf(null),
            "disabled" to listOf(null),
            "required" to listOf(null),
            "min" to listOf("2022-02"),
            "max" to listOf("2022-03"),
            "class" to listOf("clazz"),
            "step" to listOf("43"),
        ))
    }

    @Test
    fun `inputNumber function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputNumber(
            "a"["b"],
            name = "name1",
            value = 42,
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("number"),
            "name" to listOf("name1"),
            "value" to listOf("42"),
        ))
    }

    @Test
    fun `inputNumber function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputNumber(
            "a"["b"],
            name = "name1",
            value = 42,
            defaultValue = "dv",
            autoComplete = "ac",
            autoFocus = true,
            readOnly = true,
            disabled = true,
            required = true,
            min = 43,
            max = 44,
            clazz = "clazz",
            step = 43,
            placeHolder = "ph",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("42"),
            "type" to listOf("number"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "readOnly" to listOf(null),
            "disabled" to listOf(null),
            "required" to listOf(null),
            "min" to listOf("43"),
            "max" to listOf("44"),
            "class" to listOf("clazz"),
            "step" to listOf("43"),
            "placeholder" to listOf("ph"),
        ))
    }

    @Test
    fun `inputPassword function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputPassword(
            "a"["b"],
            name = "name1",
            value = "pwd",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("password"),
            "name" to listOf("name1"),
            "value" to listOf("pwd"),
        ))
    }

    @Test
    fun `inputPassword function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputPassword(
            "a"["b"],
            name = "name1",
            value = "pwd",
            defaultValue = "dv",
            autoComplete = "ac",
            autoFocus = true,
            readOnly = true,
            disabled = true,
            required = true,
            maxLength = 42,
            clazz = "clazz",
            placeHolder = "ph",
            pattern = "p",
            size = 43,
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("pwd"),
            "type" to listOf("password"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "readOnly" to listOf(null),
            "disabled" to listOf(null),
            "required" to listOf(null),
            "maxLength" to listOf("42"),
            "size" to listOf("43"),
            "class" to listOf("clazz"),
            "placeholder" to listOf("ph"),
            "pattern" to listOf("p"),
        ))
    }

    @Test
    fun `inputRange function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputRange(
            "a"["b"],
            name = "name1",
            value = 7,
            max = 10,
            min = 1,
            step = 2,
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("range"),
            "name" to listOf("name1"),
            "value" to listOf("7"),
            "max" to listOf("10"),
            "min" to listOf("1"),
            "step" to listOf("2"),
        ))
    }

    @Test
    fun `inputRange function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputRange(
            "a"["b"],
            name = "name1",
            value = 7,
            max = 10,
            min = 1,
            step = 2,
            defaultValue = "dv",
            autoComplete = "ac",
            autoFocus = true,
            disabled = true,
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("7"),
            "max" to listOf("10"),
            "min" to listOf("1"),
            "step" to listOf("2"),
            "type" to listOf("range"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputRadio function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputRadio(
            "a"["b"],
            name = "name1",
            value = "7",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("radio"),
            "name" to listOf("name1"),
            "value" to listOf("7"),
        ))
    }

    @Test
    fun `inputRadio function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputRadio(
            "a"["b"],
            name = "name1",
            value = "7",
            defaultValue = "dv",
            autoFocus = true,
            checked = true,
            required = true,
            defaultChecked = "dc",
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("7"),
            "type" to listOf("radio"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "checked" to listOf(null),
            "required" to listOf(null),
            "defaultChecked" to listOf("dc"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputReset function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputReset(
            "a"["b"],
            name = "name1",
            value = "7",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("reset"),
            "name" to listOf("name1"),
            "value" to listOf("7"),
        ))
    }

    @Test
    fun `inputReset function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputReset(
            "a"["b"],
            name = "name1",
            value = "7",
            defaultValue = "dv",
            autoFocus = true,
            disabled = true,
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("7"),
            "type" to listOf("reset"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputSearch function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputSearch(
            "a"["b"],
            name = "name1",
            value = "7",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("search"),
            "name" to listOf("name1"),
            "value" to listOf("7"),
        ))
    }

    @Test
    fun `inputSearch function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputSearch(
            "a"["b"],
            name = "name1",
            value = "7",
            autoComplete = "ac",
            autoFocus = true,
            defaultValue = "dv",
            disabled = true,
            maxLength = 42,
            pattern = "p",
            placeHolder = "ph",
            readOnly = true,
            required = true,
            size = 43,
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("7"),
            "type" to listOf("search"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "maxLength" to listOf("42"),
            "pattern" to listOf("p"),
            "placeholder" to listOf("ph"),
            "readOnly" to listOf(null),
            "required" to listOf(null),
            "size" to listOf("43"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputText function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputText(
            "a"["b"],
            name = "name1",
            value = "7",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("text"),
            "name" to listOf("name1"),
            "value" to listOf("7"),
        ))
    }

    @Test
    fun `inputText function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputText(
            "a"["b"],
            name = "name1",
            value = "7",
            autoComplete = "ac",
            autoFocus = true,
            defaultValue = "dv",
            disabled = true,
            maxLength = 42,
            pattern = "p",
            placeHolder = "ph",
            readOnly = true,
            required = true,
            size = 43,
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("7"),
            "type" to listOf("text"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "maxLength" to listOf("42"),
            "pattern" to listOf("p"),
            "placeholder" to listOf("ph"),
            "readOnly" to listOf(null),
            "required" to listOf(null),
            "size" to listOf("43"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputTime function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputTime(
            "a"["b"],
            name = "name1",
            value = LocalDateTime.parse("2022-01-06T07:08:09"),
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("time"),
            "name" to listOf("name1"),
            "value" to listOf("07:08:09"),
        ))
    }

    @Test
    fun `inputTime function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputTime(
            "a"["b"],
            name = "name1",
            value = LocalDateTime.parse("2022-01-06T07:08:09"),
            autoComplete = "ac",
            autoFocus = true,
            defaultValue = "dv",
            disabled = true,
            max = LocalDateTime.parse("2022-01-06T01:08:09"),
            min = LocalDateTime.parse("2022-01-06T09:08:09"),
            readOnly = true,
            required = true,
            step = 43,
            clazz = "clazz",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("07:08:09"),
            "type" to listOf("time"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "max" to listOf("01:08:09"),
            "min" to listOf("09:08:09"),
            "readOnly" to listOf(null),
            "required" to listOf(null),
            "step" to listOf("43"),
            "class" to listOf("clazz"),
        ))
    }

    @Test
    fun `inputUrl function works`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputUrl(
            "a"["b"],
            name = "name1",
            value = "url",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "type" to listOf("url"),
            "name" to listOf("name1"),
            "value" to listOf("url"),
        ))
    }

    @Test
    fun `inputUrl function works with all Attributes`() {
        val form = Form("id1")
        every { blockInput.invoke(any()) }.returns(Unit)

        val input = form.inputUrl(
            "a"["b"],
            name = "name1",
            value = "url",
            autoComplete = "ac",
            autoFocus = true,
            defaultValue = "dv",
            disabled = true,
            maxLength = 42,
            readOnly = true,
            required = true,
            size = 43,
            clazz = "clazz",
            pattern = "p",
            placeHolder = "ph",
            init = blockInput::invoke
        )

        verification(input, blockInput, mapOf(
            "a" to listOf("b"),
            "form" to listOf(form.id),
            "name" to listOf("name1"),
            "value" to listOf("url"),
            "type" to listOf("url"),
            "autocomplete" to listOf("ac"),
            "defaultValue" to listOf("dv"),
            "autofocus" to listOf(null),
            "disabled" to listOf(null),
            "maxLength" to listOf("42"),
            "readOnly" to listOf(null),
            "required" to listOf(null),
            "size" to listOf("43"),
            "pattern" to listOf("p"),
            "placeholder" to listOf("ph"),
            "class" to listOf("clazz"),
        ))
    }
    //</editor-fold>






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
