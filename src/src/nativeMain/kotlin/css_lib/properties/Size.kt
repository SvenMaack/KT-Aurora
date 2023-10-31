@file:Suppress("unused")
package css_lib.properties

@Suppress("EnumEntryName")
enum class CssUnit(val value: String) {
    px("px"),
    rem("rem"),
    cm("cm"),
    mm("mm"),
    Q("Q"),
    `in`("in"),
    pc("pc"),
    pt("pt"),
    em("em"),
    ex("ex"),
    ch("ch"),
    lh("lh"),
    rlh("rlh"),
    vw("vw"),
    vh("vh"),
    vmin("vmin"),
    vmax("vmax"),
    vb("vb"),
    vi("vi"),
    svw("svw"),
    svh("svh"),
    lvw("lvw"),
    lvh("lvh"),
    dvw("dvw"),
    dvh("dvh"),
    percentage("%"),
}

interface Size

open class FloatingValueSize(
    private val value: Double,
    private val unit: CssUnit
): Size {
    operator fun unaryMinus(): Size =
        FloatingValueSize(-this.value, this.unit)

    override fun toString(): String {
        return "${value}${unit.value}"
    }
}

open class ValueSize(
    private val value: Int,
    private val unit: CssUnit
): Size {
    operator fun unaryMinus(): Size =
        ValueSize(-this.value, this.unit)

    override fun toString(): String {
        return "${value}${unit.value}"
    }
}

@Suppress("ClassName")
data object auto: Size

@Suppress("ClassName")
data object inherit: Size

val Double.px: FloatingValueSize get() = FloatingValueSize(this, CssUnit.px)
val Double.rem: FloatingValueSize get() = FloatingValueSize(this, CssUnit.rem)
val Double.cm: FloatingValueSize get() = FloatingValueSize(this, CssUnit.cm)
val Double.mm: FloatingValueSize get() = FloatingValueSize(this, CssUnit.mm)
val Double.Q: FloatingValueSize get() = FloatingValueSize(this, CssUnit.Q)
val Double.`in`: FloatingValueSize get() = FloatingValueSize(this, CssUnit.`in`)
val Double.pc: FloatingValueSize get() = FloatingValueSize(this, CssUnit.pc)
val Double.pt: FloatingValueSize get() = FloatingValueSize(this, CssUnit.pt)
val Double.em: FloatingValueSize get() = FloatingValueSize(this, CssUnit.em)
val Double.ex: FloatingValueSize get() = FloatingValueSize(this, CssUnit.ex)
val Double.ch: FloatingValueSize get() = FloatingValueSize(this, CssUnit.ch)
val Double.lh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.lh)
val Double.rlh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.rlh)
val Double.vw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vw)
val Double.vh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vh)
val Double.vmin: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vmin)
val Double.vmax: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vmax)
val Double.vb: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vb)
val Double.vi: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vi)
val Double.svw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.svw)
val Double.svh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.svh)
val Double.lvw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.lvw)
val Double.lvh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.lvh)
val Double.dvw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.dvw)
val Double.dvh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.dvh)
val Double.percentage: FloatingValueSize get() = FloatingValueSize(this, CssUnit.percentage)

val Int.px: ValueSize get() = ValueSize(this, CssUnit.px)
val Int.rem: ValueSize get() = ValueSize(this, CssUnit.rem)
val Int.cm: ValueSize get() = ValueSize(this, CssUnit.cm)
val Int.mm: ValueSize get() = ValueSize(this, CssUnit.mm)
val Int.Q: ValueSize get() = ValueSize(this, CssUnit.Q)
val Int.`in`: ValueSize get() = ValueSize(this, CssUnit.`in`)
val Int.pc: ValueSize get() = ValueSize(this, CssUnit.pc)
val Int.pt: ValueSize get() = ValueSize(this, CssUnit.pt)
val Int.em: ValueSize get() = ValueSize(this, CssUnit.em)
val Int.ex: ValueSize get() = ValueSize(this, CssUnit.ex)
val Int.ch: ValueSize get() = ValueSize(this, CssUnit.ch)
val Int.lh: ValueSize get() = ValueSize(this, CssUnit.lh)
val Int.rlh: ValueSize get() = ValueSize(this, CssUnit.rlh)
val Int.vw: ValueSize get() = ValueSize(this, CssUnit.vw)
val Int.vh: ValueSize get() = ValueSize(this, CssUnit.vh)
val Int.vmin: ValueSize get() = ValueSize(this, CssUnit.vmin)
val Int.vmax: ValueSize get() = ValueSize(this, CssUnit.vmax)
val Int.vb: ValueSize get() = ValueSize(this, CssUnit.vb)
val Int.vi: ValueSize get() = ValueSize(this, CssUnit.vi)
val Int.svw: ValueSize get() = ValueSize(this, CssUnit.svw)
val Int.svh: ValueSize get() = ValueSize(this, CssUnit.svh)
val Int.lvw: ValueSize get() = ValueSize(this, CssUnit.lvw)
val Int.lvh: ValueSize get() = ValueSize(this, CssUnit.lvh)
val Int.dvw: ValueSize get() = ValueSize(this, CssUnit.dvw)
val Int.dvh: ValueSize get() = ValueSize(this, CssUnit.dvh)
val Int.percentage: ValueSize get() = ValueSize(this, CssUnit.percentage)
