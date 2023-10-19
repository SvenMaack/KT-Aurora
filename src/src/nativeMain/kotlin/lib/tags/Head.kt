package lib.tags

import lib.base.TagContainer

class Head: TagContainer("head") {
    inline fun title(init: Title.() -> Unit) = add(Title(), init)

    inline fun meta(
        name: String = "",
        content: String = "",
    ) = add(Meta()) {
        setAttributes("name"[name], "content"[content])
    }

    inline fun meta(
        charset: String = ""
    ) = add(Meta()) {
        setAttributes("charset"[charset])
    }
}
