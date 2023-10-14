package lib

import lib.base.Tag

class Comment(comment: String): Tag("!--$comment--")
