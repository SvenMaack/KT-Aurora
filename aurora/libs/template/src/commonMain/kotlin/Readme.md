A `Template` is a higher order function that can build html.
Templates can be composed by using the `include` function. 
Templates that don't have any parameter (`Unit`) are cached automatically using the `TemplateCache`.
Every template is expected to be pure!

The rendering is done by the `TemplateRenderer`.
The `Context` provides infos for the rendering.
