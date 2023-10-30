package css_lib.base

interface Visitor<T> {
    val result: T

    fun visitRule(rule: Rule)
}
