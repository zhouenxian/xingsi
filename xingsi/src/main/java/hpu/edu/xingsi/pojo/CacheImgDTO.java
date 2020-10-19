package hpu.edu.xingsi.pojo;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * @author zhou'en'xian
 * @date 2020/8/31  16:05
 */
@Data
@AllArgsConstructor

@TableName(value = "cache_img")
public class CacheImgDTO implements Serializable {
    @TableId(value = "cache_img_id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "img_url")
    private  String imgUrl;
    @TableField("img_type")
    private String type;
}
