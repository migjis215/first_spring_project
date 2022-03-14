package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {


        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {

        log.info(form.toString());

        // 1. DTO to Entity
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Entity to Repository
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);

        // 1: retrieve data using id
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2: assign the data to the model
        model.addAttribute("article", articleEntity);

        // 3: set the page to show
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {

        // 1: retrieve all data of articles
        List<Article> articleEntityList = articleRepository.findAll();

        // 2: pass the list of articles to the view
        model.addAttribute("articleList", articleEntityList);

        // 3: set the view page
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // get data to modify
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // assign the data to the model
        model.addAttribute("article", articleEntity);

        // set the view page

        return "articles/edit";
    }
}
