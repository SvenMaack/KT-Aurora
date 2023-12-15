@file:Suppress("FunctionName", "EnumEntryName", "EnumNaming", "MethodOverloading", "TooManyFunctions", "LongMethod", "LongParameterList")
package css.properties

import css.base.Property
import css.base.Rule
import css.base.browser.SupportData
import css.base.browser.SupportDataOverride
import css.base.moz
import css.base.o
import css.base.webkit

public interface TransformValue {
    public val value: String
}

/**
 * Defines a 2D transformation, using a matrix of six values
 */
public class Matrix private constructor(v1: String, v2: String, v3: String, v4: String, v5: String, v6: String) : TransformValue {
    override val value: String = "matrix($v1,$v2,$v3,$v4,$v5,$v6)"

    public constructor(v1: Size, v2: Size, v3: Size, v4: Size, v5: Size, v6: Size):
            this(v1.toString(), v2.toString(), v3.toString(), v4.toString(), v5.toString(), v6.toString())
    public constructor(v1: Double, v2: Double, v3: Double, v4: Double, v5: Double, v6: Double):
            this(v1.toString(), v2.toString(), v3.toString(), v4.toString(), v5.toString(), v6.toString())
}

/**
 * Defines a 2D translation
 */
public class Translate private constructor(v1: String, v2: String) : TransformValue {
    override val value: String = "translate($v1,$v2)"

    public constructor(v1: Size, v2: Size):
            this(v1.toString(), v2.toString())
    public constructor(v1: Double, v2: Double):
            this(v1.toString(), v2.toString())
}

/**
 * Defines a translation, using only the value for the X-axis
 */
public class TranslateX private constructor(x: String) : TransformValue {
    override val value: String = "translateX($x)"

    public constructor(x: Size):
            this(x.toString())
    public constructor(x: Double):
            this(x.toString())
}

/**
 * Defines a translation, using only the value for the Y-axis
 */
public class TranslateY private constructor(y: String) : TransformValue {
    override val value: String = "translateY($y)"

    public constructor(y: Size):
            this(y.toString())
    public constructor(y: Double):
            this(y.toString())
}

/**
 * Defines a 3D translation, using only the value for the Z-axis
 */
public class TranslateZ private constructor(z: String) : TransformValue {
    override val value: String = "translateZ($z)"

    public constructor(z: Size):
            this(z.toString())
    public constructor(z: Double):
            this(z.toString())
}

/**
 * Defines a 2D scale transformation
 */
public class Scale private constructor(v1: String, v2: String) : TransformValue {
    override val value: String = "scale($v1,$v2)"

    public constructor(v1: Size, v2: Size):
            this(v1.toString(), v2.toString())
    public constructor(v1: Double, v2: Double):
            this(v1.toString(), v2.toString())
}

/**
 * Defines a scale transformation by giving a value for the X-axis
 */
public class ScaleX private constructor(x: String) : TransformValue {
    override val value: String = "scaleX($x)"

    public constructor(x: Size):
            this(x.toString())
    public constructor(x: Double):
            this(x.toString())
}

/**
 * Defines a scale transformation by giving a value for the Y-axis
 */
public class ScaleY private constructor(y: String) : TransformValue {
    override val value: String = "scaleY($y)"

    public constructor(y: Size):
            this(y.toString())
    public constructor(y: Double):
            this(y.toString())
}

/**
 * Defines a 3D scale transformation by giving a value for the Z-axis
 */
public class ScaleZ private constructor(z: String) : TransformValue {
    override val value: String = "scaleZ($z)"

    public constructor(z: Size):
            this(z.toString())
    public constructor(z: Double):
            this(z.toString())
}

/**
 *	Defines a 2D rotation, the angle is specified in the parameter
 */
public class Rotate private constructor(angle: String) : TransformValue {
    override val value: String = "rotate($angle)"

    public constructor(angle: Size):
            this(angle.toString())
    public constructor(angle: Double):
            this(angle.toString())
}

/**
 * Defines a 3D rotation along the X-axis
 */
public class RotateX private constructor(x: String) : TransformValue {
    override val value: String = "rotateX($x)"

    public constructor(x: Size):
            this(x.toString())
    public constructor(x: Double):
            this(x.toString())
}

/**
 * Defines a 3D rotation along the Y-axis
 */
public class RotateY private constructor(y: String) : TransformValue {
    override val value: String = "rotateY($y)"

    public constructor(y: Size):
            this(y.toString())
    public constructor(y: Double):
            this(y.toString())
}

/**
 * Defines a 3D rotation along the Z-axis
 */
public class RotateZ private constructor(z: String) : TransformValue {
    override val value: String = "rotateZ($z)"

    public constructor(z: Size):
            this(z.toString())
    public constructor(z: Double):
            this(z.toString())
}

/**
 * Defines a 2D skew transformation along the X- and the Y-axis
 */
public class Skew private constructor(x: String, y: String) : TransformValue {
    override val value: String = "skew($x,$y)"

    public constructor(x: Size, y: Size):
            this(x.toString(), y.toString())
    public constructor(x: Double, y: Double):
            this(x.toString(), y.toString())
}

/**
 * Defines a 2D skew transformation along the X-axis
 */
public class SkewX private constructor(x: String) : TransformValue {
    override val value: String = "skewX($x)"

    public constructor(x: Size):
            this(x.toString())
    public constructor(x: Double):
            this(x.toString())
}

/**
 * Defines a 2D skew transformation along the Y-axis
 */
public class SkewY private constructor(y: String) : TransformValue {
    override val value: String = "skewY($y)"

    public constructor(y: Size):
            this(y.toString())
    public constructor(y: Double):
            this(y.toString())
}

/**
 * Defines a perspective view for a 3D transformed element
 */
public class Perspective private constructor(n: String) : TransformValue {
    override val value: String = "perspective($n)"

    public constructor(n: Size):
            this(n.toString())
    public constructor(n: Double):
            this(n.toString())
}

/**
 * The transform property applies a 2D transformation to an element. This property allows you to rotate, scale, move, skew, etc., elements.
 */
public inline var Rule.transform: TransformValue
    get() = inherit
    set(transform) {
        +Property(
            property = "transform",
            value = transform.value,
            supportedBrowsers = SupportData(
                chrome = 36.0,
                edge = 10.0,
                firefox = 16.0,
                safari = 9.0,
                opera = 23.0,
            )
        ).webkit(SupportDataOverride(
            safari = 3.2,
            chrome = 4.0,
            opera = 15.0,
        )).moz(SupportDataOverride(
            edge = 9.0,
            firefox = 3.5
        )).o(SupportDataOverride(
            opera = 10.5
        ))
    }

public fun Rule.transform(vararg transformations: TransformValue) {
    +Property(
        property = "transform",
        value = transformations.joinToString(" ") { it.value },
        supportedBrowsers = SupportData(
            chrome = 36.0,
            edge = 10.0,
            firefox = 16.0,
            safari = 9.0,
            opera = 23.0,
        )
    ).webkit(SupportDataOverride(
        safari = 3.2,
        chrome = 4.0,
        opera = 15.0,
    )).moz(SupportDataOverride(
        edge = 9.0,
        firefox = 3.5
    )).o(SupportDataOverride(
        opera = 10.5
    ))
}
