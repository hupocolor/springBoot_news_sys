package hl.hjc.newsdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Role)表实体类
 *
 * @author makejava
 * @since 2023-06-21 17:13:58
 */
@TableName("role")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuppressWarnings("serial")
public class Role extends Model<Role> {
    @TableId
    //权限id
    private Integer rid;
    private String roleName;

}

