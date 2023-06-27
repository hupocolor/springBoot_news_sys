package hl.hjc.newsdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hl.hjc.newsdemo.dto.NewsTitleDto;
import hl.hjc.newsdemo.entity.News;
import hl.hjc.newsdemo.service.NewsService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsService newsService;
    @GetMapping("/{id}")
    public ResponseEntity<News> getNews(@PathVariable("id")Integer id){
        return ResponseEntity.ok(newsService.getById(id));
    }

    @GetMapping("/getHotNews/{topicId}")
    public ResponseEntity<NewsTitleDto> getHotNews(@PathVariable("topicId") Integer topicId){
        return newsService.getHotNews(topicId);
    }

    @GetMapping("/getNewsPage")
    public ResponseEntity<Page<NewsTitleDto>> getNewsPage(Integer current, Integer size, Integer topicId, String keyword){
        return newsService.getNewsPage(current,size,topicId,keyword);
    }

    @GetMapping("/getByTopic")
    public ResponseEntity<Page<NewsTitleDto>> getByTopic(Integer current,Integer size,Integer topicId){
        return newsService.getNewsPage(current,size,topicId,null);
    }

    @GetMapping("/getByKey")
    public ResponseEntity<Page<NewsTitleDto>> getByKeyword(Integer current,Integer size,String keyword){
        return newsService.getNewsPage(current,size,null,keyword);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Integer id,@RequestHeader("token") String token){
        return newsService.delNews(id,token);
    }

    @PostMapping("/addNews")
    public ResponseEntity<String> addNews(@RequestBody News news,@RequestHeader("token") String token){
        return newsService.addNews(news,token);
    }

    @PostMapping("/updateNews")
    public ResponseEntity<String> updateNews(@RequestBody News news,@RequestHeader("token") String token){
        return newsService.updateNews(news,token);
    }

}
