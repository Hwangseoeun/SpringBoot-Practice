package site.practice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.practice.dto.CreateArticleRequestDto;
import site.practice.dto.UpdateArticleRequestDto;
import site.practice.entity.Article;
import site.practice.exception.ArticleNotFoundException;
import site.practice.repository.ArticleRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void saveArticle(CreateArticleRequestDto dto) {
        final Article article = Article.save(
            dto.title(),
            dto.content(),
            dto.writerName()
        );

        articleRepository.save(article);
    }

    public List<Article> findArticles() {
        return articleRepository.findAll();
    }

    public Article findArticle(Long articleId) {
        return articleRepository.findById(articleId)
            .orElseThrow(() -> new ArticleNotFoundException("존재하지 않는 게시글 id입니다. articleId: " + articleId));
    }

    @Transactional
    public void updateArticle(Long articleId, UpdateArticleRequestDto request) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> new ArticleNotFoundException("존재하지 않는 게시글 id입니다. articleId: " + articleId));

        article.update(request.title(), request.content());
        articleRepository.save(article);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }
}
