package hl.hjc.newsdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hl.hjc.newsdemo.entity.Topic;
import hl.hjc.newsdemo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;
    @GetMapping("/list")
    public ResponseEntity<List<Topic>> getTopicList(){
        return new ResponseEntity(topicService.list(), HttpStatus.OK);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Topic>> getTopicPage(Integer current, Integer size){
        return topicService.getTopics(current,size);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable("id") Integer id){
        return ResponseEntity.ok(topicService.getById(id));
    }
    @PostMapping("/addTopic")
    public ResponseEntity<String> addTopic(@RequestBody Topic topic,@RequestHeader("token") String token){
        return topicService.addTopic(topic,token);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable("id") Integer id,@RequestHeader("token") String token){
        return topicService.delTopic(id,token);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateTopic(@RequestBody Topic topic,@RequestHeader("token") String token){
        return topicService.updateTopic(topic,token);
    }
}
