package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        if (article.getId() != null) {
            return null;
        }

        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        // 1: create an entity for patch
        Article article = dto.toEntity();
        log.info("id: {}, article: {}", id, article.toString());

        // 2: get target entity
        Article target = articleRepository.findById(id).orElse(null);

        // 3: error handling
        if (target == null || id != article.getId()) {
            // 400
            log.info("Bad request! id: {}, article: {}", id, article.toString());
            return null;
        }

        // 4: update and response(200)
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        // get
        Article target = articleRepository.findById(id).orElse(null);

        // error handling
        if (target == null) {
            return null;
        }

        // delete
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // dtos to entities
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

//        List<Article> articleListFor = new ArrayList<>();
//        for (int i = 0; i < dtos.size(); i++) {
//            ArticleForm dto = dtos.get(i);
//            Article entity = dto.toEntity();
//            articleList.add(entity);
//        }

        // save entities to DB
        articleList.stream()
                .forEach(article -> articleRepository.save(article));

//        for (int i = 0; i < articleList.size(); i++) {
//            Article article = articleList.get(i);
//            articleRepository.save(article);
//        }

        // exception
        articleRepository.findById(-1L).orElseThrow(
                () -> new IllegalArgumentException("Transaction Error!")
        );

        // return
        return articleList;
    }
}
