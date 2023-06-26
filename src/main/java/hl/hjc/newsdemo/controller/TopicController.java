package hl.hjc.newsdemo.controller;

import hl.hjc.newsdemo.entity.Topic;
import hl.hjc.newsdemo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    TopicService topicService;
    @GetMapping("/list")
    public ResponseEntity getTopicList(){
        return new ResponseEntity(topicService.list(), HttpStatus.OK);
    }
    @GetMapping("/page")
    public ResponseEntity getTopicPage(Integer current,Integer size){
        return topicService.getTopics(current,size);
    }
    @GetMapping("/{id}")
    public ResponseEntity getTopic(@PathVariable("id") Integer id){
        return ResponseEntity.ok(topicService.getById(id));
    }
    @PostMapping("/addTopic")
    public ResponseEntity addTopic(@RequestBody Topic topic,@RequestHeader("token") String token){
        return topicService.addTopic(topic,token);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic(@PathVariable("id") Integer id,@RequestHeader("token") String token){
        return topicService.delTopic(id,token);
    }

    @PostMapping("/update")
    public ResponseEntity updateTopic(@RequestBody Topic topic,@RequestHeader("token") String token){
        return topicService.updateTopic(topic,token);
    }
}
