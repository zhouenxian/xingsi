package hpu.edu.xingsi.controller;

import hpu.edu.xingsi.service.ImageDeleteService;
import hpu.edu.xingsi.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhou'en'xian
 * @date 2020/9/6  9:00
 */
@RestController
public class ImageDeleteController {
    private final Logger logger=LoggerFactory.getLogger(ImageDeleteController.class);
    @Resource
    private ImageDeleteService imageDeleteService;
    @RequestMapping(value = "/image/delete/swiper")
    public Object ImageDeleteSwiper (@RequestParam("picture") String picture){

        try {
            imageDeleteService.imageDeleteSwiper(picture);
            return ResponseResult.success();
        }catch (Exception e){
            logger.error("error  /image/delete/swiper  {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }

    }

    @RequestMapping(value = "/image/delete/album/img")
    public  Object ImageDeleteAlbumImg(@RequestParam("picture") String picture){
        try {
            imageDeleteService.imageDeleteAlbumImg(picture);
            return ResponseResult.success();
        }catch (Exception e){
            logger.error("error   /image/delete/album/img   {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
}
