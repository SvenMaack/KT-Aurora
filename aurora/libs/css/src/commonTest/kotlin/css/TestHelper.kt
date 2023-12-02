package css

fun interface Callable<T1> {
    fun test(t1: T1)
}

fun interface Callable1R<T1, R> {
    fun test(t1: T1): R
}

fun interface Callable2R<T1, T2, R> {
    fun test(t1: T1, t2: T2): R
}
