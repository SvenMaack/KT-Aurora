package page_lib

fun interface Callable<T, R> {
    fun test(t1: T): R
}
