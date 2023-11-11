A `PageBuilder` can be used to create a `PageFacade` that can be used to render template with css.

The `PageBuilder` uses the `PageRenderer` as the core of a decorator chain. Decorators can be added via the `PageBuilder`. 
Additionally the `PageBuilder` allows to manipulate the input data via `StaticPageRigger`

`SimpleHeadTemplate` provides a simple `head` tag. it uses the `id` of the `context` object for the css filename.

A `Module` can be used to export all relevant css/html data from a lib.

A page can look like this:

```
PageBuilder(
    name = "foo",
    externalDocument = Document(),
    internalDocument = Document(),
    runtimeModifier = ...+...,
    staticRiggers = listOf(...),
    ...
).build()
```
