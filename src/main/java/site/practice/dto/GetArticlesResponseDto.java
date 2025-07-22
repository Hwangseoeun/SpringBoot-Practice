package site.practice.dto;

import site.practice.entity.Article;

import java.util.List;

public record GetArticlesResponseDto(List<Article> articles) {
}
