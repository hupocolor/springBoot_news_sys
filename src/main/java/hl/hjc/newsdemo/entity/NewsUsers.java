package hl.hjc.newsdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (NewsUsers)表实体类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@TableName("news_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("serial")
public class NewsUsers extends Model<NewsUsers>{

    @TableId

    private Integer uid;

    private String uname;

    private String upwd;

    private Integer roleid;



}