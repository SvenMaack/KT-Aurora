package template.base

@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR,
    message = "This should only be used when defining own template tags and never inside the DSL."
)
public annotation class TemplatingApi
