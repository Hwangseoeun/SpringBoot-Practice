package site.practice.dto;

public record UpdateArticleRequestDto(
    String title,
    String content,
    String writerName
) {
}
