package hpu.edu.xingsi.pojo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @author zhou'en'xian
 * @date 2020/9/4  21:33
 */
@Component
public class AlbumImgDTO implements Serializable {
    private MultipartFile picture;
    private Integer id;
    private String description;
    private String imgStorageUrl;

    public String getImgStorageUrl() {
        return imgStorageUrl;
    }

    public void setImgStorageUrl(String imgStorageUrl) {
        this.imgStorageUrl = imgStorageUrl;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlbumImgDTO(MultipartFile picture, Integer id, String description) {
        this.picture = picture;
        this.id = id;
        this.description = description;
    }

    public AlbumImgDTO() {
    }
}
