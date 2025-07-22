package site.practice.dto;

public record CreateArticleRequestDto(
    String title,
    String content,
    String writerName
) {

    public CreateArticleRequestDto(
        final String title,
        final String content,
        final String writerName
    ) {
        this.title = title;
        this.content = content;
        this.writerName = writerName;
    }
}
