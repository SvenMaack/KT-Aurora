package css_lib

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
}

interface Size

open class FloatingValueSize(
    private val value: Double,
    private val unit: CssUnit
): Size {
    override fun toString(): String {
        return "${value}${unit.value}"
    }
}

open class ValueSize(
    private val value: Int,
    private val unit: CssUnit
): Size {
    override fun toString(): String {
        return "${value}${unit.value}"
    }
}

@Suppress("ClassName")
data object auto: Size

@Suppress("ClassName")
data object inherit: Size

val Double.px: Size get() = FloatingValueSize(this, CssUnit.px)
val Double.rem: Size get() = FloatingValueSize(this, CssUnit.rem)
val Double.cm: Size get() = FloatingValueSize(this, CssUnit.cm)
val Double.mm: Size get() = FloatingValueSize(this, CssUnit.mm)
val Double.Q: Size get() = FloatingValueSize(this, CssUnit.Q)
val Double.`in`: Size get() = FloatingValueSize(this, CssUnit.`in`)
val Double.pc: Size get() = FloatingValueSize(this, CssUnit.pc)
val Double.pt: Size get() = FloatingValueSize(this, CssUnit.pt)
val Double.em: Size get() = FloatingValueSize(this, CssUnit.em)
val Double.ex: Size get() = FloatingValueSize(this, CssUnit.ex)
val Double.ch: Size get() = FloatingValueSize(this, CssUnit.ch)
val Double.lh: Size get() = FloatingValueSize(this, CssUnit.lh)
val Double.rlh: Size get() = FloatingValueSize(this, CssUnit.rlh)
val Double.vw: Size get() = FloatingValueSize(this, CssUnit.vw)
val Double.vh: Size get() = FloatingValueSize(this, CssUnit.vh)
val Double.vmin: Size get() = FloatingValueSize(this, CssUnit.vmin)
val Double.vmax: Size get() = FloatingValueSize(this, CssUnit.vmax)
val Double.vb: Size get() = FloatingValueSize(this, CssUnit.vb)
val Double.vi: Size get() = FloatingValueSize(this, CssUnit.vi)
val Double.svw: Size get() = FloatingValueSize(this, CssUnit.svw)
val Double.svh: Size get() = FloatingValueSize(this, CssUnit.svh)
val Double.lvw: Size get() = FloatingValueSize(this, CssUnit.lvw)
val Double.lvh: Size get() = FloatingValueSize(this, CssUnit.lvh)
val Double.dvw: Size get() = FloatingValueSize(this, CssUnit.dvw)
val Double.dvh: Size get() = FloatingValueSize(this, CssUnit.dvh)

val Int.px: Size get() = ValueSize(this, CssUnit.px)
val Int.rem: Size get() = ValueSize(this, CssUnit.rem)
val Int.cm: Size get() = ValueSize(this, CssUnit.cm)
val Int.mm: Size get() = ValueSize(this, CssUnit.mm)
val Int.Q: Size get() = ValueSize(this, CssUnit.Q)
val Int.`in`: Size get() = ValueSize(this, CssUnit.`in`)
val Int.pc: Size get() = ValueSize(this, CssUnit.pc)
val Int.pt: Size get() = ValueSize(this, CssUnit.pt)
val Int.em: Size get() = ValueSize(this, CssUnit.em)
val Int.ex: Size get() = ValueSize(this, CssUnit.ex)
val Int.ch: Size get() = ValueSize(this, CssUnit.ch)
val Int.lh: Size get() = ValueSize(this, CssUnit.lh)
val Int.rlh: Size get() = ValueSize(this, CssUnit.rlh)
val Int.vw: Size get() = ValueSize(this, CssUnit.vw)
val Int.vh: Size get() = ValueSize(this, CssUnit.vh)
val Int.vmin: Size get() = ValueSize(this, CssUnit.vmin)
val Int.vmax: Size get() = ValueSize(this, CssUnit.vmax)
val Int.vb: Size get() = ValueSize(this, CssUnit.vb)
val Int.vi: Size get() = ValueSize(this, CssUnit.vi)
val Int.svw: Size get() = ValueSize(this, CssUnit.svw)
val Int.svh: Size get() = ValueSize(this, CssUnit.svh)
val Int.lvw: Size get() = ValueSize(this, CssUnit.lvw)
val Int.lvh: Size get() = ValueSize(this, CssUnit.lvh)
val Int.dvw: Size get() = ValueSize(this, CssUnit.dvw)
val Int.dvh: Size get() = ValueSize(this, CssUnit.dvh)
