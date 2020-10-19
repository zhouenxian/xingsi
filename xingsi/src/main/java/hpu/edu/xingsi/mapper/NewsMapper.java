package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.NewsDO;
import hpu.edu.xingsi.pojo.NewsDTO;
import hpu.edu.xingsi.pojo.NewsPictureDTO;
import org.apache.ibatis.annotations.*;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/2  18:01
 */
@Mapper
public interface NewsMapper {
    //新闻上传(mapper.xml文件映射)
    @Insert("insert into news(author_name,news_title, news_picture_view_url,news_content_view, news_content)values(#{author}, #{title},#{thumb},#{head},#{content})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertOneNews(NewsDTO newsDTO);

    //修改新闻
    @Update("update news set author_name=#{author},news_title=#{title},news_picture_view_url=#{thumb},news_content_view=#{head},news_content=#{content} where news_id=#{id} ")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int updateNews(NewsDTO newsDTO);

    //根据新闻id编号删除新闻
    @Delete("delete from news where news_id=#{id}")
    int deleteNews(Integer id);

    //根据新闻id删除新闻中的图片url地址
    @Delete("delete from news_picture where news_id=#{id}")
    int deleteNewsImg(Integer id);

    @Select("select news_picture_view_url from news where news_id=#{id}")
    String selectNewsThumb(Integer id);

    //从数据库中查询出一条新闻所有的图片地址
    @Select("select picture_url from news_picture where news_id=#{id}")
    ArrayList<String> selectNewsImg(Integer id);

    //根据新闻id编号查询出一条新闻
    @Select("select * from news where news_id=#{id}")
    NewsDO selectNewsById(Integer id);

    //根据新闻id查询出该条新闻所有的图片地址
    @Select("select picture_url from news_picture where news_id=#{id}")
    List<String>selectNewsImgByNewsId(Integer id);

    //批量删除修改后丢弃的新闻图片地址
    @Delete("<script> delete from news_picture where picture_url in <foreach collection='list' item='url' open='(' separator=',' close=')'>#{url}</foreach></script>")
    void deletePatchNewsImg(List<String>list);
    //批量新增修改后新增的新闻图片
    @Insert("<script>insert into news_picture (news_id,picture_url)values<foreach collection='list' item='url'  separator=','>(#{item.newsId},#{item.imgUrl})</foreach></script>")
    void insertPatchNewsImg(List<NewsPictureDTO> list);
}
