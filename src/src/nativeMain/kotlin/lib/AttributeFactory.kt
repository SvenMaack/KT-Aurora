package lib

import lib.base.Attribute

inline operator fun String.get(value: String): Attribute = object : Attribute {
    override val name: String = this@get
    override val value: String = value
}

const val clazz = "class"
const val id = "id"
