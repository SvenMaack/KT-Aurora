package template_lib.tags

import template_lib.base.TagWithText
import template_lib.base.get

public open class TextContainer(name: String): TagWithText(name) {
    public inline fun abbr(title: String, init: Abbr.() -> Unit): Abbr = add(Abbr()) {
        setAttributes("title"[title])
        init()
    }

    public inline fun cite(init: Cite.() -> Unit): Cite = add(Cite()) {
        init()
    }

    public inline fun code(init: Code.() -> Unit): Code = add(Code()) {
        init()
    }

    public inline fun data(init: Data.() -> Unit): Data = add(Data()) {
        init()
    }

    public inline fun dfn(init: Dfn.() -> Unit): Dfn = add(Dfn()) {
        init()
    }

    public inline fun mark(init: Mark.() -> Unit): Mark = add(Mark()) {
        init()
    }

    public inline fun output(init: Output.() -> Unit): Output = add(Output()) {
        init()
    }

    public inline fun em(init: Em.() -> Unit): Em = add(Em()) {
        init()
    }

    public inline fun pre(init: Pre.() -> Unit): Pre = add(Pre()) {
        init()
    }

    public inline fun sub(init: Sub.() -> Unit): Sub = add(Sub()) {
        init()
    }
}