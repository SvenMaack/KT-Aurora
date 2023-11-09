A `Page` renders a template together with the css for any kind of DTO. You should add all Css-Documents to it before getting the CSS.

`SimpleHeadTemplate` provides a simple `head` tag. it uses the `id` of the `context` object for the css filename.

A `Module` can be used to export all relevant css/html data from a lib.


A page can look like this:

```
val FooPage: IPage<FooDto> = Page(
        "foo",
        FooTemplate,
        Styling.Builder().build()
    ).apply {
        +fooDocument1
        +fooDocument2
    }
```
