package site.practice.dto;

import java.time.LocalDateTime;

public record GetArticleResponseDto(
    String title,
    String content,
    String writerName,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
