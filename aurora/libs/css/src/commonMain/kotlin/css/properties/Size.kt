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

public class ValueSize(
    private val number: String,
    private val unit: CssUnit
): Size, MarginValue, PaddingValue, PositionDistanceValue, HeightValue, WidthValue {
    override val value: String =
        toString()

    public operator fun unaryMinus(): Size =
        ValueSize("-" + this.number, this.unit)

    override fun toString(): String =
        "${number}${unit.value}"
}

public val Double.px: ValueSize get() = ValueSize(this.toString(), CssUnit.px)
public val Double.rem: ValueSize get() = ValueSize(this.toString(), CssUnit.rem)
public val Double.cm: ValueSize get() = ValueSize(this.toString(), CssUnit.cm)
public val Double.mm: ValueSize get() = ValueSize(this.toString(), CssUnit.mm)
public val Double.Q: ValueSize get() = ValueSize(this.toString(), CssUnit.Q)
@Suppress("TopLevelPropertyNaming")
public val Double.`in`: ValueSize get() = ValueSize(this.toString(), CssUnit.`in`)
public val Double.pc: ValueSize get() = ValueSize(this.toString(), CssUnit.pc)
public val Double.pt: ValueSize get() = ValueSize(this.toString(), CssUnit.pt)
public val Double.em: ValueSize get() = ValueSize(this.toString(), CssUnit.em)
public val Double.ex: ValueSize get() = ValueSize(this.toString(), CssUnit.ex)
public val Double.ch: ValueSize get() = ValueSize(this.toString(), CssUnit.ch)
public val Double.lh: ValueSize get() = ValueSize(this.toString(), CssUnit.lh)
public val Double.rlh: ValueSize get() = ValueSize(this.toString(), CssUnit.rlh)
public val Double.vw: ValueSize get() = ValueSize(this.toString(), CssUnit.vw)
public val Double.vh: ValueSize get() = ValueSize(this.toString(), CssUnit.vh)
public val Double.vmin: ValueSize get() = ValueSize(this.toString(), CssUnit.vmin)
public val Double.vmax: ValueSize get() = ValueSize(this.toString(), CssUnit.vmax)
public val Double.vb: ValueSize get() = ValueSize(this.toString(), CssUnit.vb)
public val Double.vi: ValueSize get() = ValueSize(this.toString(), CssUnit.vi)
public val Double.svw: ValueSize get() = ValueSize(this.toString(), CssUnit.svw)
public val Double.svh: ValueSize get() = ValueSize(this.toString(), CssUnit.svh)
public val Double.lvw: ValueSize get() = ValueSize(this.toString(), CssUnit.lvw)
public val Double.lvh: ValueSize get() = ValueSize(this.toString(), CssUnit.lvh)
public val Double.dvw: ValueSize get() = ValueSize(this.toString(), CssUnit.dvw)
public val Double.dvh: ValueSize get() = ValueSize(this.toString(), CssUnit.dvh)
public val Double.percentage: ValueSize get() = ValueSize(this.toString(), CssUnit.percentage)

public val Int.px: ValueSize get() = ValueSize(this.toString(), CssUnit.px)
public val Int.rem: ValueSize get() = ValueSize(this.toString(), CssUnit.rem)
public val Int.cm: ValueSize get() = ValueSize(this.toString(), CssUnit.cm)
public val Int.mm: ValueSize get() = ValueSize(this.toString(), CssUnit.mm)
public val Int.Q: ValueSize get() = ValueSize(this.toString(), CssUnit.Q)
@Suppress("TopLevelPropertyNaming")
public val Int.`in`: ValueSize get() = ValueSize(this.toString(), CssUnit.`in`)
public val Int.pc: ValueSize get() = ValueSize(this.toString(), CssUnit.pc)
public val Int.pt: ValueSize get() = ValueSize(this.toString(), CssUnit.pt)
public val Int.em: ValueSize get() = ValueSize(this.toString(), CssUnit.em)
public val Int.ex: ValueSize get() = ValueSize(this.toString(), CssUnit.ex)
public val Int.ch: ValueSize get() = ValueSize(this.toString(), CssUnit.ch)
public val Int.lh: ValueSize get() = ValueSize(this.toString(), CssUnit.lh)
public val Int.rlh: ValueSize get() = ValueSize(this.toString(), CssUnit.rlh)
public val Int.vw: ValueSize get() = ValueSize(this.toString(), CssUnit.vw)
public val Int.vh: ValueSize get() = ValueSize(this.toString(), CssUnit.vh)
public val Int.vmin: ValueSize get() = ValueSize(this.toString(), CssUnit.vmin)
public val Int.vmax: ValueSize get() = ValueSize(this.toString(), CssUnit.vmax)
public val Int.vb: ValueSize get() = ValueSize(this.toString(), CssUnit.vb)
public val Int.vi: ValueSize get() = ValueSize(this.toString(), CssUnit.vi)
public val Int.svw: ValueSize get() = ValueSize(this.toString(), CssUnit.svw)
public val Int.svh: ValueSize get() = ValueSize(this.toString(), CssUnit.svh)
public val Int.lvw: ValueSize get() = ValueSize(this.toString(), CssUnit.lvw)
public val Int.lvh: ValueSize get() = ValueSize(this.toString(), CssUnit.lvh)
public val Int.dvw: ValueSize get() = ValueSize(this.toString(), CssUnit.dvw)
public val Int.dvh: ValueSize get() = ValueSize(this.toString(), CssUnit.dvh)
public val Int.percentage: ValueSize get() = ValueSize(this.toString(), CssUnit.percentage)
