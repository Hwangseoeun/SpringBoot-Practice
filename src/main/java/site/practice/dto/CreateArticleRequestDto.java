package site.practice.dto;

public record CreateArticleRequestDto(
    String title,
    String content,
    String writerName
) {
}
