package kz.articles.articles_app.controller;

import kz.articles.articles_app.dto.ArticleDTO;
import kz.articles.articles_app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(articleService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ArticleDTO>> getList() {
        return ResponseEntity.ok(articleService.getList());
    }

    @PostMapping()
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO articleDTO) {
        return ResponseEntity.ok(articleService.add(articleDTO));
    }

    @PutMapping()
    public ResponseEntity<ArticleDTO> update(@RequestBody ArticleDTO articleDTO) {
        return ResponseEntity.ok(articleService.update(articleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
        articleService.delete(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
