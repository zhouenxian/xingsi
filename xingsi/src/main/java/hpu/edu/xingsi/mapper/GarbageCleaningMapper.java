package hpu.edu.xingsi.mapper;

import org.apache.ibatis.annotations.Delete;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/30  16:01
 */
@Mapper
public interface GarbageCleaningMapper {
    @Select("SELECT * FROM (SELECT img_url FROM cache_img WHERE img_type='album_img') AS temp WHERE temp.img_url NOT IN (SELECT picture_url FROM wall_picture);")
    List<String> wallPictureCleaning();

    @Delete("delete  from cache_img where img_type='album_img' and img_url=#{url}")
    void deleteWallPicture(String url);

    @Select("SELECT * FROM (SELECT img_url FROM cache_img WHERE img_type='news') AS temp WHERE temp.img_url NOT IN (SELECT picture_url FROM news_picture);")
    List<String>newsImgCleaning();

    @Delete("delete from cache_img where img_type='news' and img_url=#{url}")
    void deleteNewsImg(String url);

}
