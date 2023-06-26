package hl.hjc.newsdemo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Comments)表实体类
 *
 * @author makejava
 * @since 2023-06-21 16:14:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comments")
@SuppressWarnings("serial")
public class Comments extends Model<Comments> {
@TableId
    
    private Integer cid;
    
    private Integer cnid;
    
    private String ccontent;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date cdate;
    
    private String cip;
    
    private String cauthor;



    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.cid;
    }
    }

