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
 * (News)表实体类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@TableName("news")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class News extends Model<News> {
@TableId
    
    private Integer nid;
    
    private Integer ntid;
    
    private String ntitle;
    
    private String nauthor;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date ncreatedate;
    
    private String npicpath;
    private String ncontent;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date nmodifydate;
    
    private String nsummary;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.nid;
    }
    }

