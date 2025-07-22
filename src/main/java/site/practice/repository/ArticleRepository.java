package site.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.practice.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
