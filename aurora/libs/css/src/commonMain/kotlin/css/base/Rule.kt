package css.base

import css.properties.ContentCustom
import css.properties.content

public interface IRule {
    public val properties: List<IProperty>
    public val selector: Selector

    public fun Document.before(init: BeforeAfterRule.() -> Unit)
    public fun Document.after(init: BeforeAfterRule.() -> Unit)
    public fun Document.hover(init: Rule.() -> Unit)
    public fun Document.focusWithin(init: Rule.() -> Unit)
}

public open class Rule(public override val selector: Selector): IRule {
    override val properties: MutableList<IProperty> = mutableListOf()

    public constructor(classSelector: String): this(Class(classSelector))

    public operator fun IProperty.unaryPlus(): IProperty {
        properties.removeAll { it.property == this.property }
        properties.add(this)
        return this
    }

    public override fun Document.before(init: BeforeAfterRule.() -> Unit) {
        +BeforeAfterRule(Pseudo(selector, PseudoValues.BEFORE)).apply {
            content = ContentCustom("\"\"")
            init()
        }
    }
    public override fun Document.after(init: BeforeAfterRule.() -> Unit) {
        +BeforeAfterRule(Pseudo(selector, PseudoValues.AFTER)).apply {
            content = ContentCustom("\"\"")
            init()
        }
    }
    public override fun Document.hover(init: Rule.() -> Unit) {
        +Rule(Pseudo(selector, PseudoValues.HOVER)).apply(init)
    }
    public override fun Document.focusWithin(init: Rule.() -> Unit) {
        +Rule(Pseudo(selector, PseudoValues.FOCUS_WITHIN)).apply(init)
    }
}

public class BeforeAfterRule(selector: Selector): Rule(selector) {
    public constructor(classSelector: String): this(Class(classSelector))
}
