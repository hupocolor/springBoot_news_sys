package hl.hjc.newsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hl.hjc.newsdemo.entity.Topic;
import org.springframework.http.ResponseEntity;

/**
 * (Topic)表服务接口
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
public interface TopicService extends IService<Topic> {

    ResponseEntity addTopic(Topic topic, String token);

    ResponseEntity delTopic(Integer id, String token);

    ResponseEntity updateTopic(Topic topic, String token);

    ResponseEntity getTopics(Integer current, Integer size);
}

