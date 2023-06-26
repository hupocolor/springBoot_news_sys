package hl.hjc.newsdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Topic)表实体类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@TableName("topic")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class Topic extends Model<Topic> {
    @TableId
    private Integer tid;
    private String tname;
}

