package hl.hjc.newsdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hl.hjc.newsdemo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-21 17:13:58
 */
public interface RoleDao extends BaseMapper<Role> {

}

