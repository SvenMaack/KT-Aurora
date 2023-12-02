package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportImpl

//https://www.w3schools.com/cssref/pr_class_display.php

@Suppress("EnumEntryName", "EnumNaming")
public enum class DisplayTypeValue(public val value: String) {
    @Suppress("UnnecessaryBackticks")
    `inline`("inline"),
    block("block"),
    contents("contents"),
    flex("flex"),
    `inline-block`("inline-block"),
    `inline-flex`("inline-flex"),
    `inline-grid`("inline-grid"),
    `inline-table`("inline-table"),
    `list-item`("list-item"),
    `run-in`("run-in"),
    table("table"),
    `table-caption`("table-caption"),
    `table-column-group`("table-column-group"),
    `table-header-group`("table-header-group"),
    `table-footer-group`("table-footer-group"),
    `table-row-group`("table-row-group"),
    `table-cell`("table-cell"),
    `table-column`("table-column"),
    `table-row`("table-row"),
    none("none"),
    initial("initial"),
    inherit("inherit"),
    unset("unset")
}

private val browserSupport = SupportImpl(
    chrome = { 4.0 },
    edge = { 8.0 },
    firefox = { 3.0 },
    safari = { 3.1 },
    opera = { 7.0 },
).supportedBrowsers

public fun Rule.display(style: DisplayTypeValue): Property =
    +Property.build(
        property = "display",
        value = style.value,
        defaultValue = null,
        supportedBrowsers = browserSupport
    )
