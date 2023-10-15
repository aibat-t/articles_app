package kz.articles.articles_app.helper;

import kz.articles.articles_app.dto.ArticleDTO;
import kz.articles.articles_app.model.Article;

public class ArticleMapper {

    public static ArticleDTO map(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getText(),
                article.getTopic(),
                article.getPublicDate()
        );
    }

    public static Article unmap(ArticleDTO articleDTO) {
        return new Article(
                articleDTO.getTopic(),
                articleDTO.getText(),
                articleDTO.getPublicDate()
        );
    }
}
