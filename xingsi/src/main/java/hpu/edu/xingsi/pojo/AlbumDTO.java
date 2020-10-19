package hpu.edu.xingsi.pojo;




import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/3  17:00
 */
@Component
public class AlbumDTO implements Serializable {

    private Integer id;
    private  String name;

    private String thumb;

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", thumb='" + thumb + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlbumDTO() {
    }

    public AlbumDTO(Integer id, String name, String thumb, String description) {
        this.id = id;
        this.name = name;
        this.thumb = thumb;
        this.description = description;
    }
}
