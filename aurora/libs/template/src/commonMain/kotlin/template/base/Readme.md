The following inheritance exists to create tags

                Element
                   |
                  Tag  //adds a name to the element
                   |  
          ------------------------------------------------------------------------------------------------------------
          |                  |                                                                                       |
       Comment               |                                                                                       |
                     TagWithAttributes //validates the tag name and adds attributes                             TextElement
                             |
                        TagContainer //supports tags as children
                             |
                        TagWithText  //supports pure text(TextElement) as child
                             |
                        TransientTag //just use to structure the templates, will not be rendered



Text can be added to `TagWithText` via the unary plus operator (`+`)

Comments can be added to `TagContainer` via the not operator (`!`)

The tree can be traversed using the `Visitor`

Attributes can be created in 2 ways:
- via the `Attribute` and `AttributeWithValue` interface
- via an index-access of a string via string. e.g.: `class[value]` is the equivalent of `class="value"`