package css_lib

interface Visitor<T> {
    val result: T

    fun visitRule(rule: Rule)
}
