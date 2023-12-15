@file:Suppress("ObjectPropertyName")
package basic

import css.base.Rule
import css.properties.*
import css.properties.FontWeightTextValue.`500`
import css.properties.FontWeightTextValue.`400`
import css.properties.FontWeightTextValue.`300`
import css.properties.FontWeightTextValue.`200`
import css.properties.TextTransformTextValue.uppercase

private const val FONT_SANS = "Optima, Candara, 'Noto Sans', source-sans-pro, sans-serif;"
private const val FONT_SERIF = "Charter, 'Bitstream Charter', 'Sitka Text', Cambria, serif"

public enum class TYPOGRAPHY{
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    SUBTITLE_1,
    SUBTITLE_2,
    BODY_1,
    BODY_2,
    BUTTON,
    CAPTION,
}

public var Rule._typography: TYPOGRAPHY
    get() = TYPOGRAPHY.BODY_1
    set(typography) {
        when(typography){
            TYPOGRAPHY.H1 -> {
                `font-family` = FONT_SANS
                `font-size` = (96.0/16.0).rem
                `font-weight` = `200`
                `letter-spacing` = (-1.5).px
            }
            TYPOGRAPHY.H2 -> {
                `font-family` = FONT_SANS
                `font-size` = (60.0/16.0).rem
                `font-weight` = `300`
                `letter-spacing` = (-0.5).px
            }
            TYPOGRAPHY.H3 -> {
                `font-family` = FONT_SANS
                `font-size` = (48.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.px
            }
            TYPOGRAPHY.H4 -> {
                `font-family` = FONT_SANS
                `font-size` = (34.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.25.px
            }
            TYPOGRAPHY.H5 -> {
                `font-family` = FONT_SANS
                `font-size` =(24.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.px
            }
            TYPOGRAPHY.H6 -> {
                `font-family` = FONT_SANS
                `font-size` = (20.0/16.0).rem
                `font-weight` = `500`
                `letter-spacing` = 0.15.px
            }
            TYPOGRAPHY.SUBTITLE_1 -> {
                `font-family` = FONT_SERIF
                `font-size` = (16.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.15.px
            }
            TYPOGRAPHY.SUBTITLE_2 -> {
                `font-family` = FONT_SERIF
                `font-size` = (14.0/16.0).rem
                `font-weight` = `500`
                `letter-spacing` = 0.1.px
            }
            TYPOGRAPHY.BODY_1 -> {
                `font-family` = FONT_SERIF
                `font-size` = (16.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.5.px
            }
            TYPOGRAPHY.BODY_2 -> {
                `font-family` = FONT_SERIF
                `font-size` = (14.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.25.px
            }
            TYPOGRAPHY.BUTTON -> {
                `font-family` = FONT_SANS
                `font-size` = (14.0/16.0).rem
                `font-weight` = `500`
                `letter-spacing` = 1.25.px
                `text-transform` = uppercase
            }
            TYPOGRAPHY.CAPTION -> {
                `font-family` = FONT_SERIF
                `font-size` = (12.0/16.0).rem
                `font-weight` = `400`
                `letter-spacing` = 0.4.px
            }
        }
    }
