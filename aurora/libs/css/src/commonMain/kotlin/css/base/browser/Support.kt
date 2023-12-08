package css.base.browser

private interface ISupportData<Type> {
    val chrome: Type
    val edge: Type
    val firefox: Type
    val opera: Type
    val safari: Type
}

public data class SupportData(
    public override val chrome: Double = NotSupported,
    public override val edge: Double = NotSupported,
    public override val firefox: Double = NotSupported,
    public override val opera: Double = NotSupported,
    public override val safari: Double = NotSupported,
): ISupportData<Double> {
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

public const val NotSupported: Double = 1_000_000_000.0
