package hpu.edu.xingsi.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/5  8:38
 */
@Data
public class WebsiteTypeDTO implements Serializable {
    private Integer id;
    private String description;

    @Override
    public String toString() {
        return "WebsiteTypeDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
