package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.HistoryPersonDTO;

import hpu.edu.xingsi.pojo.HistoryYearDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;



/**
 * @author zhou'en'xian
 * @date 2020/9/6  10:58
 */
@Mapper
public interface HistoryMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into history_year (year, description) values(#{year},#{description})")
    int insertHistory(HistoryYearDTO historyYearDTO);

    //人物新增接口
    @Insert("insert into history_person (name,grade,job,year_id,weight)values(#{name},#{grade},#{job},#{historyId},#{weight})")
    int insertHistoryPerson(HistoryPersonDTO historyPersonDTO);
    @Delete("delete from history_year where history_year_id=#{id}")
    int deleteHistoryYear(Integer id);
    //根据年份id查询该年份内的所有人物

    //根据人物id编号删除单个人物记录
    @Delete("delete from history_person where history_person_id=#{id}")
    int historyPersonDeleteByPersonId(Integer id);
}
