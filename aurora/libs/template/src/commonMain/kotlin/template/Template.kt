package template

import template.base.TagContainer

public typealias Template<VM> = (context: Context, data: VM) -> TagContainer

public typealias StaticTemplate = Template<Unit>
