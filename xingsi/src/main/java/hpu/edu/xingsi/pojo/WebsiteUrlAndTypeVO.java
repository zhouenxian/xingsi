package hpu.edu.xingsi.pojo;

import lombok.Data;

/**
 * @author zhou'en'xian
 * @date 2020/9/13  15:09
 */
@Data
public class WebsiteUrlAndTypeVO {
    private Integer websiteUrlId;
    private String websiteName;
    private String typeId;
    private String url;
    private WebsiteTypeDO websiteTypeDO;
}
