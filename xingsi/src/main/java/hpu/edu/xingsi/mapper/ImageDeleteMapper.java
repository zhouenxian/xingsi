package hpu.edu.xingsi.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhou'en'xian
 * @date 2020/9/10  17:43
 */
@Mapper
public interface ImageDeleteMapper {
    @Delete("delete from swiper_picture where swiper_picture_url=#{url}")
    int imageDeleteAlbumImg(String url);

    @Delete("delete from wall_picture where picture_url=#{url}")
    int imageDeleteSwiper(String url);
}
