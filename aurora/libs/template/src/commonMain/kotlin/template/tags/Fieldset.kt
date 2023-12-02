package template.tags

public class Fieldset(id: String): Form(id, "fieldset") {
    public inline fun legend(init: Legend.() -> Unit): Legend = add(Legend()) {
        init()
    }
}
