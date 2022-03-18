package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
        // Look up
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        // entity -> dto
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for (int i = 0; i < comments.size(); i++) {
//            Comment c = comments.get(i);
//            CommentDto dto = CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }

        //return
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // Look up and throw exceptions
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("Error: There is no post for this ID"));

        // create comment entity
        Comment comment = Comment.createComment(dto, article);

        // store the entity to the DB
        Comment created = commentRepository.save(comment);

        // return
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // Look up and throw exception
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Error: There is no comment for this ID"));

        // update comment
        target.patch(dto);

        // update DB
        Comment updated = commentRepository.save(target);

        // comment entity -> DTO
        return CommentDto.createCommentDto((updated));
    }

    @Transactional
    public CommentDto delete(Long id) {
        // Look up and throw exception
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Error: There is no comment for this ID"));

        // delete comment in DB
        commentRepository.delete(target);

        // comment deleted -> DTO
        return CommentDto.createCommentDto(target);
    }
}
