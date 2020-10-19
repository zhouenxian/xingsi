package hpu.edu.xingsi.controller;


import hpu.edu.xingsi.pojo.AlbumImgDTO;
import hpu.edu.xingsi.pojo.SwiperImgDTO;
import hpu.edu.xingsi.service.ImageUploadService;
import hpu.edu.xingsi.util.ImageUploadUtil;

import hpu.edu.xingsi.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author zhou'en'xian
 * @date 2020/9/4  17:23
 */
@RestController
@RequestMapping(value = "/image/upload" )
public class ImageUploadController {
    @Resource
    private ImageUploadUtil imageUploadUtil;
    @Resource
    private ImageUploadService imageUploadService;

    private Logger logger=LoggerFactory.getLogger(ImageDeleteController.class);
    @RequestMapping("/swiper")
    //首页轮播图上传接口
    public Object ImageUploadSwiper(@RequestParam("file") MultipartFile file){
        try {
            HashMap<String, String> stringHashMap = imageUploadUtil.imagesUpload(file);
            SwiperImgDTO swiperImgDTO =new SwiperImgDTO(null,stringHashMap.get("url"),null);
            imageUploadService.swiperImgUpload(swiperImgDTO);
            return ResponseResult.success().data("img",stringHashMap);
        } catch (IOException e) {
            logger.error("error  /image/upload/swiper  {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //新闻图片上传接口
    @RequestMapping("/news")
    public Object ImageUploadNews(@RequestParam("file")MultipartFile file){
        try {
            HashMap<String, String> stringHashMap = imageUploadService.newsImgUpload(file);
            return ResponseResult.success().data("img",stringHashMap);
        } catch (IOException e) {
            logger.error("error  /image/upload/news  {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //新闻缩略图上传接口
    @RequestMapping("/news/thumb")
    public  Object imageUploadNewsThumb(@RequestParam("file")MultipartFile file){
        try {
            HashMap<String, String> stringHashMap = imageUploadService.newsImgThumbUpload(file);
            return ResponseResult.success().data("img",stringHashMap);
        } catch (IOException e) {
            logger.error("error    /image/upload/news/thumb   {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
   //相册缩略略图上传接口
    @RequestMapping("/album/thumb")
    public Object imageUploadAlbumThumb(@RequestParam("file")MultipartFile file)  {
        try {
            HashMap<String, String> stringHashMap = imageUploadService.albumImgThumbUpload(file);
            return ResponseResult.success().data("img",stringHashMap);
        } catch (IOException e) {
            logger.error("error    /image/upload/album/thumb   {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    };
    //相册图片上传接口
    @RequestMapping("/album")
    public Object imageUploadAlbum(@RequestParam("file")MultipartFile file)  {
        try {
            HashMap<String, String> stringHashMap = imageUploadService.albumImgUpload(file);
            return ResponseResult.success().data("img",stringHashMap);
        } catch (IOException e) {
            logger.error("error    /image/upload/album     {} ",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }

    };
}
