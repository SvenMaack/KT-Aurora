package css_lib.base.browser

interface Browser {
    fun minimalSupportedVersion(): Double

    fun browserName(): String
}
