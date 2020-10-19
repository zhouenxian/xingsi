package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.NewsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/20  21:03
 */
@Mapper
public interface SearchMapper {
    @Select("select * from news where news_title like '%${message}%' ")
    List<NewsDO> newsSearch(String message);
}
