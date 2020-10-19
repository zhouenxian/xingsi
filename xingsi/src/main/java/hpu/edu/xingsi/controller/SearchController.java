package hpu.edu.xingsi.controller;

import hpu.edu.xingsi.pojo.NewsDO;
import hpu.edu.xingsi.service.SearchService;
import hpu.edu.xingsi.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/20  20:57
 */
@RestController
public class SearchController {
    private final Logger logger=LoggerFactory.getLogger(SearchController.class);
    @Resource
    private SearchService searchService;
    @RequestMapping("/news/search")
    public Object newsSearch(@RequestBody HashMap<String,String> map){
        try {
            String message = map.get("message");
            List<NewsDO> newsDOS = searchService.newsSearch(message);
            return ResponseResult.success()
                    .data("total",newsDOS.size())
                    .data("news_data",newsDOS);
        }catch (Exception e){
            logger.error("error    /news/search       {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
}
