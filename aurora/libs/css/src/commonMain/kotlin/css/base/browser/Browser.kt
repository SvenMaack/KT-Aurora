package css.base.browser

public interface Browser {
    public val browserName: String

    public fun minimalSupportedVersion(): Double
}
