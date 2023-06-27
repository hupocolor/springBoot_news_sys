package hl.hjc.newsdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hl.hjc.newsdemo.entity.Comments;
import hl.hjc.newsdemo.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentsService commentsService;
    @GetMapping("/list")
    public ResponseEntity<Page<Comments>> getComments(Integer current, Integer size, Integer newsId){
        return commentsService.getComments(current,size,newsId);
    }

    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comments comment,@RequestHeader("token") String token){
        return commentsService.addComment(comment,token);
    }
}
