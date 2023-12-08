package css.base.browser

private interface ISupportData<Type> {
    val chrome: Type
    val edge: Type
    val firefox: Type
    val opera: Type
    val safari: Type
}

public data class SupportData(
    public override val chrome: Double = NOT_SUPPORTED,
    public override val edge: Double = NOT_SUPPORTED,
    public override val firefox: Double = NOT_SUPPORTED,
    public override val opera: Double = NOT_SUPPORTED,
    public override val safari: Double = NOT_SUPPORTED,
): ISupportData<Double> {
    @Suppress("CyclomaticComplexMethod")
    public operator fun plus(
        extension: SupportDataOverride
    ): SupportData = this.copy(
        chrome = extension.chrome ?: chrome,
        edge = extension.edge ?: edge,
        firefox = extension.firefox ?: firefox,
        opera = extension.opera ?: opera,
        safari = extension.safari ?: safari,
    )
}

public data class SupportDataOverride(
    public override val chrome: Double? = null,
    public override val edge: Double? = null,
    public override val firefox: Double? = null,
    public override val opera: Double? = null,
    public override val safari: Double? = null,
): ISupportData<Double?>

public interface Support {
    public val supportedBrowsers: SupportData
}

public const val NOT_SUPPORTED: Double = 1_000_000_000.0
