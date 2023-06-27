package hl.hjc.newsdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hl.hjc.newsdemo.dao.NewsDao;
import hl.hjc.newsdemo.dto.NewsTitleDto;
import hl.hjc.newsdemo.entity.Comments;
import hl.hjc.newsdemo.entity.News;
import hl.hjc.newsdemo.service.CommentsService;
import hl.hjc.newsdemo.service.NewsService;
import hl.hjc.newsdemo.utils.BeanCopyUtils;
import hl.hjc.newsdemo.utils.LoginProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (News)表服务实现类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, News> implements NewsService {

    @Autowired
    LoginProperties loginProperties;
    @Autowired
    CommentsService commentsService;
    @Override
    public ResponseEntity getHotNews(Integer topicId) {
        LambdaQueryWrapper<News> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(News::getNtid,topicId);
        lambdaQueryWrapper.orderByDesc(News::getNcreatedate);
        Page<News> page = page(new Page<>(1, 5), lambdaQueryWrapper);
        List<News> records = page.getRecords();
        List<NewsTitleDto> newsTitleDtos = BeanCopyUtils.copyBeanList(records, NewsTitleDto.class);
        return ResponseEntity.ok(newsTitleDtos);
    }

    @Override
    public ResponseEntity getNewsPage(Integer current, Integer size, Integer topicId, String keyword) {
        LambdaQueryWrapper<News> newsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (topicId != null && topicId > 0){
            newsLambdaQueryWrapper.eq(News::getNtid,topicId);
        }
        if (!Strings.isBlank(keyword)){
            newsLambdaQueryWrapper.like(News::getNtitle,keyword);
            newsLambdaQueryWrapper.like(News::getNauthor,keyword);
        }
        newsLambdaQueryWrapper.orderByDesc(News::getNcreatedate);
        Page<News> page = page(new Page<>(current, size),newsLambdaQueryWrapper);
        List<News> records = page.getRecords();
        Page<NewsTitleDto> titles = new Page<>();
        List<NewsTitleDto> newsTitleDtos = BeanCopyUtils.copyBeanList(records, NewsTitleDto.class);
        titles.setRecords(newsTitleDtos);
        titles.setTotal(page.getTotal());
        return ResponseEntity.ok(titles);
    }

    @Override
    public ResponseEntity delNews(Integer id, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        boolean byId = removeById(id);
        if (byId) return ResponseEntity.ok("操作成功");
        LambdaQueryWrapper<Comments> commentsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        commentsLambdaQueryWrapper.eq(Comments::getCnid,id);
        //将评论也删除
        commentsService.remove(commentsLambdaQueryWrapper);
        return new ResponseEntity("该新闻已经删除",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity addNews(News news, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        LambdaQueryWrapper<News> newsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        newsLambdaQueryWrapper.eq(News::getNtitle,news.getNtitle());
        if (getOne(newsLambdaQueryWrapper)!=null) return new ResponseEntity("标题重复",HttpStatus.BAD_REQUEST);
        save(news);
        return ResponseEntity.ok("操作成功");
    }

    @Override
    public ResponseEntity updateNews(News news, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        LambdaQueryWrapper<News> newsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (getOne(newsLambdaQueryWrapper)!=null) return new ResponseEntity("标题重复",HttpStatus.BAD_REQUEST);
        updateById(news);
        return ResponseEntity.ok("操作成功");
    }


}

