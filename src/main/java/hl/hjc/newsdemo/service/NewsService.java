package hl.hjc.newsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hl.hjc.newsdemo.entity.News;
import org.springframework.http.ResponseEntity;

/**
 * (News)表服务接口
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
public interface NewsService extends IService<News> {

    ResponseEntity getHotNews(Integer topicId);

    ResponseEntity getNewsPage(Integer current, Integer size, Integer topicId,String keyword);

    ResponseEntity delNews(Integer id, String token);

    ResponseEntity addNews(News news, String token);

    ResponseEntity updateNews(News news, String token);

}

