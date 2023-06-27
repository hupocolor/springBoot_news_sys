package hl.hjc.newsdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hl.hjc.newsdemo.dao.CommentsDao;
import hl.hjc.newsdemo.entity.Comments;
import hl.hjc.newsdemo.service.CommentsService;
import hl.hjc.newsdemo.utils.CommentUtils;
import hl.hjc.newsdemo.utils.LoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Calendar;

/**
 * (Comments)表服务实现类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, Comments> implements CommentsService {

    @Autowired
    LoginProperties loginProperties;
    @Override
    public ResponseEntity getComments(Integer current, Integer size, Integer newsId) {
        LambdaQueryWrapper<Comments> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Comments::getCnid,newsId);
        Page<Comments> page = page(new Page<>(current, size), lambdaQueryWrapper);
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity addComment(Comments comment,String token) {
        if (!loginProperties.getIsLogin(token)) return new ResponseEntity<>("需要登录后操作", HttpStatus.BAD_REQUEST);
        if (loginProperties.getRole(token) == 2) return new ResponseEntity<>("权限不足",HttpStatus.BAD_REQUEST);
        if (!CommentUtils.judgeComment(comment)) return new ResponseEntity<>("评论格式错误",HttpStatus.BAD_REQUEST);
        comment.setCdate(Calendar.getInstance().getTime());
        comment.setCcontent(CommentUtils.censorSensitiveWords(comment.getCcontent()));
        save(comment);
        return ResponseEntity.ok("操作成功");
    }
}

