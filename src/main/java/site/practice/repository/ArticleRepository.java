package site.practice.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import site.practice.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Slice<Article> findAllBy(Pageable pageable);
}
