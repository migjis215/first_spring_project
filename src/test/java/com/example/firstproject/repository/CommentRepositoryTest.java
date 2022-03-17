package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("Look up all comments on a specific post")
    void findByArticleId() {
        /* Case 1: Look up all comments on the post No. 4 */
        {
            // Arrange
            Long articleId = 4L;

            // Act
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // Expect
            Article article = new Article(4L, "for", "444");
            Comment a = new Comment(1L, article, "nick_1", "comment");
            Comment b = new Comment(2L, article, "nick_2", "comment");
            Comment c = new Comment(3L, article, "nick_3", "comment");
            List<Comment> expected = Arrays.asList(a, b, c);

            // Assert
            assertEquals(expected.toString(), comments.toString(), "Print all comments on the post No. 4");
        }

        /* Case 2: Look up all comments on the post No. 1 */
        {
            // Arrange
            Long articleId = 1L;

            // Act
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // Expect
            Article article = new Article(4L, "aaa", "111");
            List<Comment> expected = Arrays.asList();

            // Assert
            assertEquals(expected.toString(), comments.toString(), "Print all comments on the post No. 1");
        }
    }

    @Test
    @DisplayName("Look up all comments on a specific nickname")
    void findByNickname() {
        /* Case 1: Look up all comments on the "nick_1" */
        {
            // Arrange
            String nickname = "nick_1";

            // Act
            List<Comment> comments = commentRepository.findByNickname(nickname);

            // Expect
            Comment a = new Comment(1L, new Article(4L, "for", "444"), "nick_1", "comment");
            Comment b = new Comment(4L, new Article(5L, "the", "555"), "nick_1", "comment");
            Comment c = new Comment(7L, new Article(6L, "comments", "666"), "nick_1", "comment");
            List<Comment> expected = Arrays.asList(a, b, c);

            // Assert
            assertEquals(expected.toString(), comments.toString(), "Print all comments on the nick_1");
        }
    }
}