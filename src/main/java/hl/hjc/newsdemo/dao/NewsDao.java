package hl.hjc.newsdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hl.hjc.newsdemo.entity.News;
import org.apache.ibatis.annotations.Mapper;

/**
 * (News)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@Mapper
public interface NewsDao extends BaseMapper<News> {

}

