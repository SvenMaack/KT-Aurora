The following inheritance exists to create tags

                Element
                   |
                  Tag  //adds a name to the element
                   |  
          -------------------
          |                  |
       Comment               |
                     TagWithAttributes //validates the tag name
                             |
                        TagContainer //supports tags as children
                             |
                        TagWithText  //supports pure text as child
                             |
                        TransientTag //just use to structure the templates, will not be rendered



Text can be added to `TagWithText` via the unary plus operator (`+`)

Comments can be added to `TagContainer` via the not operator (`!`)


Attributes can be created in 2 ways:
- via the Attribute interface
- via an index-access of a string via string. e.g.: `class[value]` is the equivalent of `class="value"`