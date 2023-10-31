package css_lib.properties

import css_lib.base.Property
import css_lib.base.Rule

fun Rule.transform(x: Size, y: Size): Rule {
    add(Property("-webkit-transform", "translate($x,$y)"))
    return add(Property("transform", "translate($x,$y)"))
}
