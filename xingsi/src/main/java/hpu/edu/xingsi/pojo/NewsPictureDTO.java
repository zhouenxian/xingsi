package hpu.edu.xingsi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * @author zhou'en'xian
 * @date 2020/9/2  20:24
 */
@TableName(value = "news_picture")
public class NewsPictureDTO {
    public NewsPictureDTO() {
    }
    @TableId(value = "news_picture_id",type = IdType.AUTO)
    private Integer id;
    @TableField("news_id")
    private Integer newsId;
    @TableField("picture_url")
    private String imgUrl;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public NewsPictureDTO(Integer newsId, String imgUrl) {
        this.newsId = newsId;
        this.imgUrl = imgUrl;
    }
}
