package site.practice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record GetArticleResponseDto(
    @Schema(description = "게시글 제목 : 30글자 이하")
    String title,
    @Schema(description = "게시글 내용 : 2000글자 이하")
    String content,
    @Schema(description = "작성자 이름 : 5글자 이하")
    String writerName,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
