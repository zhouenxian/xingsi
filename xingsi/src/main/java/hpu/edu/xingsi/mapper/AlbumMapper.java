package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.AlbumDO;
import hpu.edu.xingsi.pojo.AlbumDTO;
import hpu.edu.xingsi.pojo.WallPictureDO;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


/**
 * @author zhou'en'xian
 * @date 2020/9/3  20:14
 */
@Mapper
public interface AlbumMapper {
    //新增相册
    @Insert("insert into album(album_name,album_description,album_thumb)values(#{name},#{description},#{thumb})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertAlbum(AlbumDTO albumDTO);

    //新增相册中的图片
    @Insert("insert into wall_picture(picture_url,picture_description,album_id)values(#{pictureUrl},#{pictureDescription},#{albumId})")
    @Options(useGeneratedKeys = true,keyProperty = "wallPictureId")
    int insertAlbumPicture(WallPictureDO wallPictureDO);

    //更新相册
    @Update("update album set album_name=#{albumName},album_description=#{albumDescription},album_thumb=#{albumThumb} where album_id=#{albumId}")
    @Options(useGeneratedKeys = true,keyProperty = "albumId")
    int updateAlbum(AlbumDO albumDO);

    //删除相册
    @Delete("delete from album where album_id=#{id}")
    int deleteAlbum (Integer id);

    //查找相册缩略图url地址
    @Select("select album_thumb from album where album_id = #{id}")
    String selectAlbumThumbUrl(Integer id);

    //查找相册中包含的所有图片的Url地址
    @Select("select picture_url from wall_picture where album_id=#{id}")
    ArrayList<String> selectAlbumImgUrl(Integer id);

    //查询所有相册
    @Select("select * from album ")
    ArrayList <AlbumDO> selectAlbumAll();

   //查询具体相册中所有的图片
    @Select("select * from wall_picture where album_id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "wallPictureId")
    ArrayList<WallPictureDO> selectAlbumImg(Integer id);

    //删除某一个具体相册中的某一个图片的数据库记录
    @Delete("delete from wall_picture where wall_picture_id=#{id}")
    void deleteAlbumPicture(Integer id);

    //修改某一个具体相册中的某一个图片的数据库记录
    @Update("update  wall_picture set picture_url=#{pictureUrl},picture_description=#{pictureDescription} where wall_picture_id=#{wallPictureId}")
    @Options(useGeneratedKeys = true,keyProperty = "wallPictureId")
    int updateAlbumPicture(WallPictureDO wallPictureDO);
}
