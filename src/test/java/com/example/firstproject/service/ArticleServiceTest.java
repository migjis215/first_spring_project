package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // expected
        Article a = new Article(1L, "aaa", "111");
        Article b = new Article(2L, "bbb", "222");
        Article c = new Article(3L, "ccc", "333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // actual
        List<Article> articles = articleService.index();

        // compare
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_success____existing_id() {
        // expected
        Long id = 1L;
        Article expected = new Article(id, "aaa", "111");

        // actual
        Article article = articleService.show(id);

        // compare
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_fail____not_existing_id() {
        // expected
        Long id = -1L;
        Article expected = null;

        // actual
        Article article = articleService.show(id);

        // compare
        assertEquals(expected, article);
//        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_success____only_title_and_content() {
        // expected
        String title = "ddd";
        String content = "444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // actual
        Article article = articleService.create(dto);

        // compare
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_fail____id_included() {
        // expected
        String title = "ddd";
        String content = "444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        // actual
        Article article = articleService.create(dto);

        // compare
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_success____existing_id_and_title() {

    }

    @Test
    @Transactional
    void update_fail____not_existing_id() {

    }

    @Test
    @Transactional
    void update_fail____only_id() {

    }

    @Test
    @Transactional
    void delete_fail____existing_id() {

    }

    @Test
    @Transactional
    void delete_fail____not_existing_id() {

    }
}