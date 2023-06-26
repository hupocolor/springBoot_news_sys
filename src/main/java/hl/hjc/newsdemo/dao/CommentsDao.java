package hl.hjc.newsdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hl.hjc.newsdemo.entity.Comments;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Comments)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-21 16:14:39
 */
@Mapper
public interface CommentsDao extends BaseMapper<Comments> {

}

