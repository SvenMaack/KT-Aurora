package lib.base

inline operator fun String.get(value: String): Attribute = object : Attribute {
    override val name: String = this@get
    override val value: String = value
}

const val clazz = "class"
const val id = "id"
const val tabindex = "tabindex"
const val height = "height"
const val width = "width"
const val target = "target"
