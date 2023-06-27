package hl.hjc.newsdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hl.hjc.newsdemo.dao.TopicDao;
import hl.hjc.newsdemo.entity.Topic;
import hl.hjc.newsdemo.service.TopicService;
import hl.hjc.newsdemo.utils.LoginProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * (Topic)表服务实现类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@Service("topicService")
public class TopicServiceImpl extends ServiceImpl<TopicDao, Topic> implements TopicService {

    @Autowired
    LoginProperties loginProperties;
    @Override
    public ResponseEntity addTopic(Topic topic, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity<>("权限不足",HttpStatus.BAD_REQUEST);
        if (judeTopic(topic)!=null) return judeTopic(topic);
        boolean save = save(topic);
        if (save) return ResponseEntity.ok("操作成功");
        return new ResponseEntity("操作失败",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity delTopic(Integer id, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        boolean remove = removeById(id);
        if (remove) return ResponseEntity.ok("操作成功");
        return new ResponseEntity("操作失败",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity updateTopic(Topic topic, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        if (judeTopic(topic)!=null) return judeTopic(topic);
        boolean update = updateById(topic);
        if (update) return ResponseEntity.ok("操作成功");
        return new ResponseEntity("操作失败",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity getTopics(Integer current, Integer size) {
        Page<Topic> page = page(new Page<Topic>(current, size));
        return ResponseEntity.ok(page);
    }

    public ResponseEntity judeTopic(Topic topic){
        if (topic.getTname().length()<1 || topic.getTname().length()>5) return new ResponseEntity<>("主题名格式错误",HttpStatus.BAD_REQUEST);
        LambdaQueryWrapper<Topic> topicLambdaQueryWrapper = new LambdaQueryWrapper<>();
        topicLambdaQueryWrapper.eq(Topic::getTname,topic.getTname());
        if (getOne(topicLambdaQueryWrapper) != null) return new ResponseEntity("主题重复",HttpStatus.BAD_REQUEST);
        return null;
    }
}

