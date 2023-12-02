package template.tags

import template.base.TagWithAttributes

/**
 * The base-tag specifies the base URL and/or target for all relative URLs in a document. The base-tag must have either an href or a target attribute present, or both.
 */
public class Base: TagWithAttributes("base")
