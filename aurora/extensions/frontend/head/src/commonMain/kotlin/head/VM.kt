package head

public interface SeoVM {
    public val title: String
    public val description: String
    public val keywords: String
    public val canonicalUrl: String
}

public interface CssVM {
    public val externalStylingPath: String
    public val inlineStyling: String
}

public interface TechnicalDataVM {
    public val seo: SeoVM
    public val css: CssVM
}
