package lib.base

inline operator fun String.get(value: String): Attribute = object : Attribute {
    override val name: String = this@get
    override val value: String = value
}
