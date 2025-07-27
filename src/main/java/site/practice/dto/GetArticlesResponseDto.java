package site.practice.dto;

import org.springframework.data.domain.Slice;

import java.util.List;

public record GetArticlesResponseDto<T>(
    List<T> articles,
    PageInfoDto pageInfo
) {
    public record PageInfoDto(
        int totalPageCount,
        int recentPageNumber,
        boolean hasNext,
        int pageSize
    ) {
    }

    public static <T> GetArticlesResponseDto<T> from(Slice<T> slice) {
        return new GetArticlesResponseDto<>(
            slice.getContent(),
            new PageInfoDto(
                slice.getPageable().getPageSize(),
                slice.getPageable().getPageNumber(),
                slice.hasNext(),
                slice.getSize()
            )
        );
    }
}
