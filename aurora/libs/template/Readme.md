Adds a template engine for html tags.

Templates can be created as `DynamicTemplate` or `StaticTemplate`.
`StaticTemplate` templates are always cached!

Every Tag is a function and can be composed in a type safe way.

Templates can be rendered by `TemplateRenderer`.
The `Context` holds some general data to render a page and must be passed to every rendering.
To compose templates use `include` or `childs` inside a `TagContainer`. The first adds all elements and the latter only the childs of the passed tag.

Rendering of a template happens via a `HtmlVisitor`.