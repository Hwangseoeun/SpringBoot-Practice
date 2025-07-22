package site.practice.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import site.practice.dto.CreateArticleRequestDto;
import site.practice.dto.GetArticleResponseDto;
import site.practice.dto.GetArticlesResponseDto;
import site.practice.dto.UpdateArticleRequestDto;

@Tag(name = "게시글 API")
public interface ArticleControllerDocs {

    @Operation(summary = "게시글 생성 api")
    ResponseEntity<site.practice.common.response.ApiResponse<Void>> createArticle(CreateArticleRequestDto dto);

    @Operation(summary = "전체 게시글 조회 api")
    ResponseEntity<site.practice.common.response.ApiResponse<GetArticlesResponseDto>> getArticles();

    @Operation(summary = "게시글 조회 api")
    ResponseEntity<site.practice.common.response.ApiResponse<GetArticleResponseDto>> getAticle(Long articleId);

    @Operation(summary = "게시글 수정 api")
    ResponseEntity<site.practice.common.response.ApiResponse<Void>> updateArticle(Long articleId, UpdateArticleRequestDto dto);

    @Operation(summary = "게시글 삭제 api")
    ResponseEntity<site.practice.common.response.ApiResponse<Void>> deleteArticle(Long articleId);
}
