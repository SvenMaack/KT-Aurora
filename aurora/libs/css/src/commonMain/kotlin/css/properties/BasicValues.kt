@file:Suppress("ClassName")
package css.properties

/**
 * Inherits this property from its parent element.
 */
public object inherit:
    BoxSizingValue,
    BorderRadiusValue,
    ColorValue,
    ContentValue,
    CursorValue,
    DisplayTypeValue,
    FontValue,
    FontFamilyValue,
    FontSizeValue,
    FontStyleValue,
    FontVariantValue,
    FontWeightValue,
    HeightValue,
    LetterSpacingValue,
    ListStylePositionValue,
    ListStyleImageValue,
    ListStyleTypeValue,
    ListStyleValue,
    OpacityValue,
    PositionDistanceValue,
    ScrollBehaviourValue,
    TextTransformValue,
    TextRenderingValue,
    LineHeightValue,
    WidthValue,
    TransformValue,
    MarginValue,
    PaddingValue,
    FlexWrapValue,
    FlexDirectionValue,
    FlexBasisValue,
    FlexGrowValue,
    FlexShrinkValue,
    FlexValue
{
    override val value: String
        get() = "inherit"
}

/**
 * Sets this property to its default value.
 */
public object initial:
    BoxSizingValue,
    BorderRadiusValue,
    ColorValue,
    ContentValue,
    CursorValue,
    DisplayTypeValue,
    FontValue,
    FontFamilyValue,
    FontSizeValue,
    FontStyleValue,
    FontVariantValue,
    FontWeightValue,
    HeightValue,
    LetterSpacingValue,
    ListStylePositionValue,
    ListStyleImageValue,
    ListStyleTypeValue,
    ListStyleValue,
    OpacityValue,
    PositionDistanceValue,
    ScrollBehaviourValue,
    TextTransformValue,
    TextRenderingValue,
    LineHeightValue,
    WidthValue,
    TransformValue,
    MarginValue,
    PaddingValue,
    FlexWrapValue,
    FlexDirectionValue,
    FlexBasisValue,
    FlexGrowValue,
    FlexShrinkValue,
    FlexValue
{
    override val value: String
        get() = "initial"
}

public object none:
    DisplayTypeValue,
    TextTransformValue,
    TransformValue,
    FlexValue
{
    override val value: String
        get() = "none"
}
