package css.properties

@Suppress("EnumEntryName", "EnumNaming", "TopLevelPropertyNaming")
public enum class CssUnit(public val value: String) {
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

public interface Size

public open class FloatingValueSize(
    private val value: Double,
    private val unit: CssUnit
): Size {
    public operator fun unaryMinus(): Size =
        FloatingValueSize(-this.value, this.unit)

    override fun toString(): String =
        "${value}${unit.value}"
}

public open class ValueSize(
    private val value: Int,
    private val unit: CssUnit
): Size {
    public operator fun unaryMinus(): Size =
        ValueSize(-this.value, this.unit)

    override fun toString(): String =
        "${value}${unit.value}"
}

@Suppress("ClassName")
public data object auto: Size

@Suppress("ClassName")
public data object inherit: Size

public val Double.px: FloatingValueSize get() = FloatingValueSize(this, CssUnit.px)
public val Double.rem: FloatingValueSize get() = FloatingValueSize(this, CssUnit.rem)
public val Double.cm: FloatingValueSize get() = FloatingValueSize(this, CssUnit.cm)
public val Double.mm: FloatingValueSize get() = FloatingValueSize(this, CssUnit.mm)
public val Double.Q: FloatingValueSize get() = FloatingValueSize(this, CssUnit.Q)
@Suppress("TopLevelPropertyNaming")
public val Double.`in`: FloatingValueSize get() = FloatingValueSize(this, CssUnit.`in`)
public val Double.pc: FloatingValueSize get() = FloatingValueSize(this, CssUnit.pc)
public val Double.pt: FloatingValueSize get() = FloatingValueSize(this, CssUnit.pt)
public val Double.em: FloatingValueSize get() = FloatingValueSize(this, CssUnit.em)
public val Double.ex: FloatingValueSize get() = FloatingValueSize(this, CssUnit.ex)
public val Double.ch: FloatingValueSize get() = FloatingValueSize(this, CssUnit.ch)
public val Double.lh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.lh)
public val Double.rlh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.rlh)
public val Double.vw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vw)
public val Double.vh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vh)
public val Double.vmin: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vmin)
public val Double.vmax: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vmax)
public val Double.vb: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vb)
public val Double.vi: FloatingValueSize get() = FloatingValueSize(this, CssUnit.vi)
public val Double.svw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.svw)
public val Double.svh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.svh)
public val Double.lvw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.lvw)
public val Double.lvh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.lvh)
public val Double.dvw: FloatingValueSize get() = FloatingValueSize(this, CssUnit.dvw)
public val Double.dvh: FloatingValueSize get() = FloatingValueSize(this, CssUnit.dvh)
public val Double.percentage: FloatingValueSize get() = FloatingValueSize(this, CssUnit.percentage)

public val Int.px: ValueSize get() = ValueSize(this, CssUnit.px)
public val Int.rem: ValueSize get() = ValueSize(this, CssUnit.rem)
public val Int.cm: ValueSize get() = ValueSize(this, CssUnit.cm)
public val Int.mm: ValueSize get() = ValueSize(this, CssUnit.mm)
public val Int.Q: ValueSize get() = ValueSize(this, CssUnit.Q)
@Suppress("TopLevelPropertyNaming")
public val Int.`in`: ValueSize get() = ValueSize(this, CssUnit.`in`)
public val Int.pc: ValueSize get() = ValueSize(this, CssUnit.pc)
public val Int.pt: ValueSize get() = ValueSize(this, CssUnit.pt)
public val Int.em: ValueSize get() = ValueSize(this, CssUnit.em)
public val Int.ex: ValueSize get() = ValueSize(this, CssUnit.ex)
public val Int.ch: ValueSize get() = ValueSize(this, CssUnit.ch)
public val Int.lh: ValueSize get() = ValueSize(this, CssUnit.lh)
public val Int.rlh: ValueSize get() = ValueSize(this, CssUnit.rlh)
public val Int.vw: ValueSize get() = ValueSize(this, CssUnit.vw)
public val Int.vh: ValueSize get() = ValueSize(this, CssUnit.vh)
public val Int.vmin: ValueSize get() = ValueSize(this, CssUnit.vmin)
public val Int.vmax: ValueSize get() = ValueSize(this, CssUnit.vmax)
public val Int.vb: ValueSize get() = ValueSize(this, CssUnit.vb)
public val Int.vi: ValueSize get() = ValueSize(this, CssUnit.vi)
public val Int.svw: ValueSize get() = ValueSize(this, CssUnit.svw)
public val Int.svh: ValueSize get() = ValueSize(this, CssUnit.svh)
public val Int.lvw: ValueSize get() = ValueSize(this, CssUnit.lvw)
public val Int.lvh: ValueSize get() = ValueSize(this, CssUnit.lvh)
public val Int.dvw: ValueSize get() = ValueSize(this, CssUnit.dvw)
public val Int.dvh: ValueSize get() = ValueSize(this, CssUnit.dvh)
public val Int.percentage: ValueSize get() = ValueSize(this, CssUnit.percentage)
