A `Template` is a higher order function that can build a html tree.
```kotlin
html{
    head {
        title("Hello World")
    }
    body {
        h1(clazz="class1", "attribute"["value"]) {
            +"Hello World"
        }
        div("attribute2"["value1", "value2"])
    }
}   
```

Templates can be composed by using the `include` function. 
```kotlin
html {
    include(context = context, template = someTemplate)
}
```

Comments and Text can also be added
```kotlin
p {
    +"Hello World"
    !"This is a comment"
}
```

Attributes can be set conditionally
```kotlin
p("attribute"["value"%condition]) {
}
```

Templates that don't have any parameter (`Unit`) can be cached automatically using the `cache` function by passing the parent constructor as a reference.
```kotlin
html {
    cache(context = context, template = someTemplate, ref=::Div)
}
```
When using the cache function make sure to save the template in a variable and don't create it dynamically; else the cache would not work.

The rendering is done by the `TemplateRenderer`.
The `Context` provides infos for the rendering.

To extend the Html-DSL you can use the following two base classes:
- `BodyTagContainer` for tags that can hold all tags that are allowed in a body
- `TextContainer` for tags that can hold text








