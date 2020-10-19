package hpu.edu.xingsi.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhou'en'xian
 * @date 2020/9/12  19:04
 */
@Data
@TableName("news")
public class NewsDO  implements Serializable {
    @TableId("news_id")
    private Integer newsId;
    @TableField("author_name")
    private String authorName;
    @TableField("create_time")
    private Date createTime;
    @TableField("visited")
    private Integer visited;
    @TableField("news_title")
    private String newsTitle;
    @TableField("news_picture_view_url")
    private String newsPictureViewUrl;
    @TableField("news_content_view")
    private String newsContentView;
    @TableField("news_content")
    private String newsContent;

}
