package hpu.edu.xingsi.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/26  10:23
 */
@Data
public class WebsiteUrlDO implements Serializable {
    private Integer websiteUrlId;
    private String websiteName;
    private Integer typeId;
    private String url;
    private String description;
}
