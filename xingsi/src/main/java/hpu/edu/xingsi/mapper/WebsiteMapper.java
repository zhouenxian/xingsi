package hpu.edu.xingsi.mapper;

import hpu.edu.xingsi.pojo.WebsiteTypeDO;
import hpu.edu.xingsi.pojo.WebsiteTypeDTO;

import hpu.edu.xingsi.pojo.WebsiteUrlDO;
import hpu.edu.xingsi.pojo.WebsiteUrlDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/5  8:34
 */
@Mapper
public interface WebsiteMapper {
    //网站类型新增接口
    @Insert("insert into website_type(type_description)values(#{description})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertWebsiteType(WebsiteTypeDTO websiteTypeDTO);

    //按照网站类型id编号删除网站类型
    @Delete("delete from website_type where website_type_id=#{id}")
    int deleteWebsiteType(Integer id);

    //修改网站类型描述
    @Update("update website_type set type_description=#{description} where website_type_id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int updateWebsiteType(WebsiteTypeDTO websiteTypeDTO);

    //新增网站类型中的网站url地址
    @Insert("insert into website_url(type_id,url,website_name,description)values(#{websiteTypeId},#{url},#{name},#{description})")
    @Options(useGeneratedKeys = true,keyProperty = "websiteUrlId")
    int insertWebsiteUrl(WebsiteUrlDTO websiteUrlDTO);

    //修改网站类型中的网站url地址
    @Update("update website_url set website_name=#{name},type_id=#{websiteTypeId},url=#{url},description=#{description} where website_url_id=#{websiteUrlId}")
    @Options(useGeneratedKeys = true,keyProperty = "websiteUrlId")
    int updateWebsiteUrl(WebsiteUrlDTO websiteUrlDTO);

    //根据url的id编号删除url地址
    @Delete("delete from website_url where website_url_id=#{id}")
    int deleteWebsiteUrl(Integer id);

    //查询所有的网站类型
    @Select("select * from website_type ")
    List<WebsiteTypeDO> selectWebsiteTypeAll();

    //根据网站类型id查询该类型下的所有url地址
    @Select("select * from website_url where type_id=#{typeId}")
    List<WebsiteUrlDO> selectWebsiteUrlByWebsiteTypeId(Integer typeId);
}
