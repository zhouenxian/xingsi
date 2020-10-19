package hpu.edu.xingsi.pojo;



/**
 * @author zhou'en'xian
 * @date 2020/9/4  17:36
 */

public class SwiperImgDTO {
    private Integer id;
   private String swiperPictureUrl;
   private String JumpUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSwiperPictureUrl() {
        return swiperPictureUrl;
    }

    public void setSwiperPictureUrl(String swiperPictureUrl) {
        this.swiperPictureUrl = swiperPictureUrl;
    }

    public String getJumpUrl() {
        return JumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        JumpUrl = jumpUrl;
    }

    public SwiperImgDTO() {
    }

    public SwiperImgDTO(Integer id, String swiperPictureUrl, String jumpUrl) {
        this.id = id;
        this.swiperPictureUrl = swiperPictureUrl;
        JumpUrl = jumpUrl;
    }
}
