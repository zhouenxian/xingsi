package hpu.edu.xingsi.pojo;


import lombok.Data;

/**
 * @author zhou'en'xian
 * @date 2020/9/12  17:15
 */
@Data
public class WallPictureDO {
    private Integer wallPictureId;
    private String  pictureUrl;
    private String  pictureDescription;
    private String createTime;
    private Integer albumId;

    public WallPictureDO() {
    }

    public Integer getWallPictureId() {
        return wallPictureId;
    }

    public void setWallPictureId(Integer wallPictureId) {
        this.wallPictureId = wallPictureId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "WallPictureDO{" +
                "wallPictureId=" + wallPictureId +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", pictureDescription='" + pictureDescription + '\'' +
                ", createTime='" + createTime + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}
