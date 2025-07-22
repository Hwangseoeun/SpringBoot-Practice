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
import site.practice.dto.GetArticlesResponseDto;
import site.practice.dto.UpdateArticleRequestDto;
import site.practice.entity.Article;
import site.practice.service.ArticleService;

import java.util.List;

import static site.practice.dto.ArticleSuccessCode.*;

@RequiredArgsConstructor
@RequestMapping("/api/article")
@RestController
public class ArticleController implements ArticleControllerDocs {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createArticle(
        @RequestBody CreateArticleRequestDto request
    ) {
        articleService.saveArticle(request);

        return ResponseEntity.ok(
            ApiResponse.success(CREATE_ARTICLE)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<GetArticlesResponseDto>> getArticles(){

        final List<Article> articles = articleService.findArticles();
        final GetArticlesResponseDto response = new GetArticlesResponseDto(articles);

        return ResponseEntity.ok(
            ApiResponse.successWithData(
                GET_ARTICLES,
                response
            )
        );
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ApiResponse<GetArticleResponseDto>> getAticle(
        @PathVariable Long articleId
    ) {
        final Article article = articleService.findArticle(articleId);
        final GetArticleResponseDto response = new GetArticleResponseDto(article);

        return ResponseEntity.ok(
            ApiResponse.successWithData(
                GET_ARTICLE,
                response
            )
        );
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<ApiResponse<Void>> updateArticle(
        @PathVariable Long articleId,
        @RequestBody UpdateArticleRequestDto request
    ) {
        articleService.updateArticle(articleId, request);

        return ResponseEntity.ok(
            ApiResponse.success(UPDATE_ARTICLE)
        );
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<ApiResponse<Void>> deleteArticle(
        @PathVariable Long articleId
    ) {
        articleService.deleteArticle(articleId);

        return ResponseEntity.ok(
            ApiResponse.success(DELETE_ARTICLE)
        );
    }
}
