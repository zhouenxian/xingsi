package hpu.edu.xingsi.service;

import hpu.edu.xingsi.mapper.WebsiteMapper;
import hpu.edu.xingsi.pojo.*;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/5  9:02
 */
@Service
public class WebsiteService {
    @Resource
    private WebsiteMapper websiteMapper;
    public int insertWebsiteType(WebsiteTypeDTO websiteTypeDTO){
        return websiteMapper.insertWebsiteType(websiteTypeDTO);
    };
    public int insertWebsiteUrl(WebsiteUrlDTO websiteUrlDTO){
        return websiteMapper.insertWebsiteUrl(websiteUrlDTO);
    };
    public  int deleteWebsiteUrl(Integer id){
        return websiteMapper.deleteWebsiteUrl(id);
    }
    public int deleteWebsiteType(Integer id){
        return websiteMapper.deleteWebsiteType(id);
    }
    public int updateWebsiteType(WebsiteTypeDTO websiteTypeDTO){
        return websiteMapper.updateWebsiteType(websiteTypeDTO);
    }
    //查询所有的网站类型
    public List<WebsiteTypeDO> selectWebsiteTypeAll(){
        return websiteMapper.selectWebsiteTypeAll();
    }
    //修改类目下的网址信息
    public int updateWebsiteUrl(WebsiteUrlDTO websiteUrlDTO){
        return websiteMapper.updateWebsiteUrl(websiteUrlDTO);
    }
    //根据网站类型id查询该类型下的网站url
    public List<WebsiteUrlDO> selectWebsiteUrlByWebsiteTypeId(Integer typeId){
        return websiteMapper.selectWebsiteUrlByWebsiteTypeId(typeId);
    }
}
