package hpu.edu.xingsi.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhou'en'xian
 * @date 2020/9/12  15:30
 */
@Data
public class AlbumDO implements Serializable {
    private Integer albumId;
    private String albumName;
    private Date albumTime;
    private String albumDescription;
    private String albumThumb;

    public AlbumDO() {
    }

    @Override
    public String toString() {
        return "AlbumDO{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumTime=" + albumTime +
                ", albumDescription='" + albumDescription + '\'' +
                ", albumThumb='" + albumThumb + '\'' +
                '}';
    }
}
