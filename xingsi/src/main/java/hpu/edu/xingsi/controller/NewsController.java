package hpu.edu.xingsi.controller;

import hpu.edu.xingsi.pojo.NewsDO;
import hpu.edu.xingsi.pojo.NewsDTO;
import hpu.edu.xingsi.pojo.NewsPictureDTO;
import hpu.edu.xingsi.service.NewsPictureInsertService;
import hpu.edu.xingsi.service.NewsService;
import hpu.edu.xingsi.util.ParseHtmlUtil;
import hpu.edu.xingsi.util.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * @author zhou'en'xian
 * @date 2020/9/2  16:01
 */
@Api(tags = "新闻相关接口")
@RestController
public class NewsController {
    private final Logger logger=LoggerFactory.getLogger(NewsController.class);
    @Resource
    private NewsService newsService;
    @Resource
    private ParseHtmlUtil parseHtmlUtil;
    @Resource
    private NewsPictureInsertService newsPictureInsertService;
    //新闻新增接口
    @ApiOperation(value = "添加接口")
    @RequestMapping(value = "/news/add")
    public Object newsInsert(@RequestBody NewsDTO newsDTO){
        try {
            logger.info("info     /news/add    {}",newsDTO.toString());
            String content = newsDTO.getContent();
            newsService.newsInsertOneNews(newsDTO);
            int newsId=newsDTO.getId();
            List<String> list = parseHtmlUtil.parseHtmlImg(content);
            NewsPictureDTO newsPictureDTO=new NewsPictureDTO();
            newsPictureDTO.setNewsId(newsId);
            for (String s : list) {
                newsPictureDTO.setImgUrl(s);
                newsPictureInsertService.insertNewsImg(newsPictureDTO);
            }
            return ResponseResult.success()
                    .data("id",newsId);
        }catch (Exception e){
            logger.error("新闻上传接口出现异常：{}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //新闻删除接口
    @ApiOperation("删除接口")
   @RequestMapping(value = "/news/delete/{id}")
    public Object newsDelete(@ApiParam(value = "新闻id号",required = true) @PathVariable(value = "id") Integer id){
       try {
           newsService.newsDelete(id);
           return ResponseResult.success();
       }catch (Exception e){
           logger.error("新闻删除出现异常:{}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }

    }
    //新闻修改接口
    @RequestMapping("/news/update")
    @ApiOperation("修改接口")
    public Object updateNews(@RequestBody NewsDTO newsDTO){
       try {
            newsService.updateNews(newsDTO);
            int id= newsDTO.getId();
           return ResponseResult.success().data("id",id);
       }catch (Exception e){
           logger.error("新闻修改失败：{}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }
    }
    //按照id编号查询一条新闻
    @RequestMapping("/news/select/{id}")
    public Object selectNewsById(@PathVariable("id") Integer id){
       try {
           NewsDO newsDO = newsService.selectNewsById(id);
           return ResponseResult
                   .success()
                   .data("news_data",newsDO);
       }catch (Exception e){
           logger.error("error    /news/select/id   {}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
       }
    }
   //分页查询新闻
    @RequestMapping("/news/select/page")
    public Object selectNewsByPage(@RequestBody Map<String,Integer> map){
        //第几页
        int page=map.get("page");
        //一页多少条数据
        int limit=map.get("limit");
        Object o = newsService.selectNewsByPage(page, limit);
        try {
            return ResponseResult.success().data("news_data",o);
        }catch (Exception e){
            logger.error("error   /news/select/page  {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
}
