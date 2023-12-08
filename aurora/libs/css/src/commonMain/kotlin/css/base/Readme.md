A `Document` contains several `rules` which itself contains several `properties`

Adding css to a rule can be done via 
```
Document().apply {
    this[".navigation"] = {
        margin(50.px)
    }
}
```
this uses the classes
```
<Document> {
    this[String] = <Rule>{
        <Property>
    }
}
```

`Document`s can be combined using the `DocumentComposite`

`Visitor`s can be used to traverse the `Rules` of a `Document`. It can be used via the `CssRenderer`.