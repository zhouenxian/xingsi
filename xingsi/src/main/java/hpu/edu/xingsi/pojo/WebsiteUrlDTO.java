package hpu.edu.xingsi.pojo;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/5  9:22
 */
public class WebsiteUrlDTO implements Serializable {
    public WebsiteUrlDTO() {
    }

    public WebsiteUrlDTO(Integer websiteTypeId, Integer websiteUrlId, String url, String name, String description) {
        this.websiteTypeId = websiteTypeId;
        this.websiteUrlId = websiteUrlId;
        this.url = url;
        this.name = name;
        this.description = description;
    }

    public Integer getWebsiteTypeId() {
        return websiteTypeId;
    }

    public void setWebsiteTypeId(Integer websiteTypeId) {
        this.websiteTypeId = websiteTypeId;
    }

    public Integer getWebsiteUrlId() {
        return websiteUrlId;
    }

    public void setWebsiteUrlId(Integer websiteUrlId) {
        this.websiteUrlId = websiteUrlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private Integer websiteUrlId;
    private Integer websiteTypeId;
    private String url;
    private  String name;
    private String description;

    @Override
    public String toString() {
        return "WebsiteUrlDTO{" +
                "websiteTypeId=" + websiteTypeId +
                ", websiteUrlId=" + websiteUrlId +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
