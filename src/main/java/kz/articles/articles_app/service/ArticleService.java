package kz.articles.articles_app.service;

import jakarta.persistence.EntityNotFoundException;
import kz.articles.articles_app.dto.ArticleDTO;
import kz.articles.articles_app.helper.ArticleMapper;
import kz.articles.articles_app.model.Article;
import kz.articles.articles_app.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ArticleDTO> getList() {
        List<Article> articleList = articleRepository.findAll();
        List<ArticleDTO> articleDTOList = articleList.stream().map(ArticleMapper::map)
                .toList();
        return articleDTOList;
    }

    public ArticleDTO add(ArticleDTO articleDTO) {
        Article article = ArticleMapper.unmap(articleDTO);
        return ArticleMapper.map(articleRepository.save(article));
    }

    public ArticleDTO update(ArticleDTO articleDTO) {
        Article article = ArticleMapper.unmap(articleDTO);
        article.setId(articleDTO.getId());
        return ArticleMapper.map(articleRepository.save(article));
    }

    public void delete (Long id) {
        articleRepository.deleteById(id);
    }
}
