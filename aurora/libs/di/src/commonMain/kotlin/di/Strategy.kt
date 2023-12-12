package di

import kotlin.reflect.KFunction0
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction3

public typealias Strategy<T> = () -> T

public infix fun <R> KFunction0<R>.by(decorator: KFunction1<R, R>): () -> R =
    { decorator(this()) }
public infix fun <R> Strategy<R>.by(decorator: KFunction1<R, R>): () -> R =
    { decorator(this()) }

public operator fun<P1,R> KFunction1<P1, R>.get(p: () -> P1): () -> R =
    { this(p()) }
public operator fun<P1,P2,R> KFunction2<P1,P2,R>.get(p1: () -> P1, p2: () -> P2): () -> R =
    { this(p1(),p2()) }
public operator fun<P1,P2,P3,R> KFunction3<P1,P2,P3,R>.get(p1: () -> P1, p2: () -> P2, p3: () -> P3): () -> R =
    { this(p1(),p2(), p3()) }
