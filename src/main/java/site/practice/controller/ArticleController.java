package site.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.practice.common.response.ApiResponse;
import site.practice.docs.ArticleControllerDocs;
import site.practice.dto.CreateArticleRequestDto;
import site.practice.dto.GetArticleResponseDto;
import site.practice.dto.UpdateArticleRequestDto;

import java.time.LocalDateTime;

import static site.practice.dto.ArticleSuccessCode.*;

@RequiredArgsConstructor
@RequestMapping("/api/article")
@RestController
public class ArticleController implements ArticleControllerDocs {

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createArticle(
        @RequestBody CreateArticleRequestDto request
    ) {
        return ResponseEntity.ok(
            ApiResponse.success(CREATE_ARTICLE)
        );
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ApiResponse<GetArticleResponseDto>> getAtiticle(
        @PathVariable Long articleId
    ) {
        final GetArticleResponseDto dto = new GetArticleResponseDto(
            "title",
            "content",
            "writer Name",
            LocalDateTime.now(),
            LocalDateTime.now()
        );

        return ResponseEntity.ok(
            ApiResponse.successWithData(
                GET_ARTICLE,
                dto
            )
        );
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<ApiResponse<Void>> updateArticle(
        @PathVariable Long articleId,
        @RequestBody UpdateArticleRequestDto request
    ) {
        return ResponseEntity.ok(
            ApiResponse.success(UPDATE_ARTICLE)
        );
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<ApiResponse<Void>> deleteArticle(
        @PathVariable Long articleId
    ) {
        return ResponseEntity.ok(
            ApiResponse.success(DELETE_ARTICLE)
        );
    }
}
