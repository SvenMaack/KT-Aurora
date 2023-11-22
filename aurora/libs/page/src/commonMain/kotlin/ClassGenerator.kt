package page_lib

object ClassGenerator {
    private var counter = 0

    operator fun invoke(prefix: String): String =
        "$prefix${++counter}"
}
