package template.tags

import template.base.TagWithAttributes

public interface Accept {
    public val value: String
}
public enum class AcceptByType(override val value: String): Accept {
    AUDIO("audio/*"),
    VIDEO("video/*"),
    IMAGE("image/*"),
}
public data class CustomAccept(override val value: String): Accept

public class Input: TagWithAttributes("input")
