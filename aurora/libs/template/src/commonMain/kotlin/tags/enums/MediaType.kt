package template_lib.tags.enums

public interface MediaType {
    public val value: String
}

/**
 * Binary data that require an application
 */
public enum class ApplicationType(public override val value: String): MediaType {
    ATOM_XML("application/atom+xml"),
    ATOM_OCTET_STREAM("application/octet-stream"),
    ATOM_AMAZON_EBOOK("application/vnd.amazon.ebook"),
    ATOM_EPUB("application/epub+zip"),
    ATOM_ZIP("application/zip"),
    ATOM_PDF("application/pdf"),
    ATOM_JSON("application/json"),
    ATOM_JAR("application/java-archive"),
    ATOM_MS_WORD("application/msword"),
    ATOM_MS_WORD_XML("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
}

/**
 * Audio and music files
 */
public enum class AudioType(public override val value: String): MediaType {
    MPEG("audio/mpeg"),
    OGG("audio/ogg"),
    WAV("audio/wav"),
}

/**
 * Font and typeface files
 */
public enum class FontType(public override val value: String): MediaType {
    FONT("font/pdf"),
}

/**
 * Graphical data formats
 */
public enum class ImageType(public override val value: String): MediaType {
    JPEG("image/jpeg"),
    PNG("image/png"),
    AVIF("image/avif"),
    WEBP("image/webp"),
    SVG("image/svg+xml"),
    TIFF("image/tiff"),
    GIF("image/gif"),
    BMP("image/bmp"),
}

/**
 * Email and messaging formats
 */
public enum class MessageType(public override val value: String): MediaType {
    HTTP("message/http"),
    EMAIL_PARTIAL("message/partial"),
    EMAIL_RFC("message/rfc822"),
    EMAIL_IMDN("message/imdn+xml"),
    PDF("message/pdf"),
}

/**
 * Model data to create 2d or 3d scenes
 */
public enum class ModelType(public override val value: String): MediaType {
    PDF("model/http")
}

/**
 * Data with multiple media types
 */
public enum class MultipartType(public override val value: String): MediaType {
    PDF("multipart/http")
}

/**
 * Readable text files
 */
public enum class TextType(public override val value: String): MediaType {
    PLAIN("text/plain"),
    HTML("text/html"),
    CSS("text/css"),
    JS("text/javascript"),
    CSV("text/csv"),
    PDF("text/pdf")
}

/**
 * Video and movie files
 */
public enum class VideoType(public override val value: String): MediaType {
    MP4("audio/mp4"),
    OGG("audio/ogg"),
    MPEG("audio/mpeg"),
}
