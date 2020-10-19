package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.AlbumImgDTO;
import hpu.edu.xingsi.pojo.CacheImgDTO;
import hpu.edu.xingsi.pojo.SwiperImgDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhou'en'xian
 * @date 2020/9/4  17:30
 */
@Mapper
public interface ImageUploadMapper {
    //数据库中记录首页图片上传url
    @Insert("insert into swiper_picture (swiper_picture_url) values(#{swiperPictureUrl})")
    int swiperImgUpload(SwiperImgDTO swiperImgDTO);

    //数据库中记录新闻图片缓冲url
    @Insert("insert into cache_img(img_url,img_type)values(#{imgUrl},#{type})")
    int cacheImgUpload(CacheImgDTO cacheImgDTO);


}
