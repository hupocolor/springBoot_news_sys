package hl.hjc.newsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hl.hjc.newsdemo.entity.Comments;
import org.springframework.http.ResponseEntity;

/**
 * (Comments)表服务接口
 *
 * @author makejava
 * @since 2023-06-21 16:14:41
 */
public interface CommentsService extends IService<Comments> {

    ResponseEntity getComments(Integer current, Integer size, Integer newsId);

    ResponseEntity addComment(Comments comment, String token);
}

