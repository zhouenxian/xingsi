package hpu.edu.xingsi.controller;

import hpu.edu.xingsi.pojo.WebsiteTypeDO;
import hpu.edu.xingsi.pojo.WebsiteTypeDTO;
import hpu.edu.xingsi.pojo.WebsiteUrlDO;
import hpu.edu.xingsi.pojo.WebsiteUrlDTO;
import hpu.edu.xingsi.service.WebsiteService;
import hpu.edu.xingsi.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/5  9:05
 */

@RestController
@RequestMapping("/website")
public class WebsiteController {
    private final Logger logger= LoggerFactory.getLogger(WebsiteController.class);
    @Resource
    private WebsiteService websiteService;
    //新增链接类目
    @RequestMapping("/add")
    public Object insertWebsiteType(@RequestBody WebsiteTypeDTO websiteTypeDTO){
        try {
            logger.info("info    /website/add    {}",websiteTypeDTO.toString());
            websiteService.insertWebsiteType(websiteTypeDTO);
            int websiteId=websiteTypeDTO.getId();
            return ResponseResult.success().data("id",websiteId);
        }catch (Exception e){
            logger.error("error    /website/add    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //向某一个链接类目中增加网站信息
    @RequestMapping("/detail/add")
    public Object insertWebsiteUrl(@RequestBody WebsiteUrlDTO websiteUrlDTO){
        try {
            logger.info("info    /website/detail/add     {}",websiteUrlDTO.toString());
            websiteService.insertWebsiteUrl(websiteUrlDTO);
            return ResponseResult
                    .success()
                    .data("website_url_id",websiteUrlDTO.getWebsiteUrlId());
        }catch (Exception e){
            logger.error("error    /website/detail/add    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }

    }

    @RequestMapping("/detail/delete/{id}")
    public Object deleteWebsiteUrl(@PathVariable(value = "id") Integer sid){
        try {
            websiteService.deleteWebsiteUrl(sid);
            return ResponseResult.success();
        }catch (Exception e){
            logger.error("error    /website/detail/delete/id    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }

    @RequestMapping("/delete/{id}")
   public Object deleteWebsiteType(@PathVariable(value = "id") Integer id){
       try {
           websiteService.deleteWebsiteType(id);
           return ResponseResult.success();
       }catch (Exception e){
           logger.error("error    /website/delete/id    {}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }
   }

    @RequestMapping("/update/type")
   public Object updateWebsiteType(@RequestBody WebsiteTypeDTO websiteTypeDTO){
       try {
           logger.info("info     /website/update    {}",websiteTypeDTO.toString());
           websiteService.updateWebsiteType(websiteTypeDTO);
           int id=websiteTypeDTO.getId();
           return ResponseResult.success().data("id",id);
       }catch (Exception e){
           logger.error("error      /website/update     {}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }
   }
   //查询所有的网站类型
   @RequestMapping("/select/type/all")
   public Object selectWebsiteTypeAll(){
       try {
           List<WebsiteTypeDO> websiteTypeDOS = websiteService.selectWebsiteTypeAll();
           return ResponseResult.success()
                   .data("total",websiteTypeDOS.size())
                   .data("website_type_data",websiteTypeDOS);
       }catch (Exception e){
           logger.error("error     /website/select/type/all     {}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }
   }
   //按照网站类型id查询该类目下所有的网站url地址
   @RequestMapping("/select/url/{id}")
   public Object selectWebsiteUrlByWebsiteTypeId(@PathVariable("id") Integer tyepId){
       try {
           List<WebsiteUrlDO> websiteUrlDTOS = websiteService.selectWebsiteUrlByWebsiteTypeId(tyepId);
           return ResponseResult.success().data("person_msg",websiteUrlDTOS);
       }catch (Exception e){
           logger.error("error     /website/select/url/id    {}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }
   }
   //修改某一个类目下的网址信息
    @RequestMapping("/update/url")
    public Object updateWebsiteUrl(@RequestBody WebsiteUrlDTO websiteUrlDTO){
        try {
            websiteService.updateWebsiteUrl(websiteUrlDTO);
            int urlId=websiteUrlDTO.getWebsiteUrlId();
            return ResponseResult.success().data("website_url_id",urlId);
        }catch (Exception e){
            logger.error("error     /website/update/url/    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
}
