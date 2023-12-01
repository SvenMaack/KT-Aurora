package template.visitors

@PublishedApi
internal object AttributeRenderer {
    fun renderAttributes(attributes: Map<String, List<String?>>): String =
        attributes.entries.joinToString(" ") {
            renderOneAttribute(it)
        }

    private inline fun renderOneAttribute(entry: Map.Entry<String, List<String?>>): String {
        val values = entry.value.filter { !it.isNullOrEmpty() }
        return if(values.isEmpty())
            entry.key
        else
            "${entry.key}=\"${this.renderValuesOfOneAttribute(values)}\""
    }

    private inline fun renderValuesOfOneAttribute(values: List<String?>): String =
        values.joinToString(" ")
}
