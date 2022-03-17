package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    // Look up comments list
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        List<CommentDto> dtos = commentService.comments(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // Create a comment
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) {
        CommentDto createdDto = commentService.create(articleId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // Update a comment
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto) {
        CommentDto updatedDto = commentService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    // Delete a comment
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        CommentDto updatedDto = commentService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }
}
