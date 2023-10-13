package kz.articles.articles_app.service;

import jakarta.persistence.EntityNotFoundException;
import kz.articles.articles_app.dto.ArticleDTO;
import kz.articles.articles_app.helper.ArticleMapper;
import kz.articles.articles_app.model.Article;
import kz.articles.articles_app.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDTO getById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Article with id " + id + " not found"));
        return ArticleMapper.map(article);
    }
}
