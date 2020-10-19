package hpu.edu.xingsi.controller;

import hpu.edu.xingsi.pojo.AlbumDO;
import hpu.edu.xingsi.pojo.AlbumDTO;
import hpu.edu.xingsi.pojo.WallPictureDO;
import hpu.edu.xingsi.service.AlbumService;
import hpu.edu.xingsi.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


import java.util.ArrayList;

import java.util.TreeMap;

/**
 * @author zhou'en'xian
 * @date 2020/9/3  16:59
 */
@RestController
public class AlbumController {
    @Resource
    private AlbumService albumService;
    //相册新建接口
    Logger logger= LoggerFactory.getLogger(AlbumController.class);
    @RequestMapping(value = "/album/add")
    public ResponseResult InsertAlbum(@RequestBody AlbumDTO albumDTO){
        try{
            logger.info("info     /album/add     参数：{}",albumDTO.toString());
            albumService.insertAlbum(albumDTO);
            int albumId=albumDTO.getId();
            TreeMap<String,Object>treeMap=new TreeMap<>();
            treeMap.put("id",albumId);
            return ResponseResult.success().data(treeMap);
        }catch (Exception e){
            logger.error("error     /album/add    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //相册修改接口
    @RequestMapping(value = "/album/update")
    public Object updateAlbum(@RequestBody AlbumDO albumDO){
        try {
            logger.info("info     /album/update    {}",albumDO.toString());
            albumService.updateAlbum(albumDO);
            int albumId=albumDO.getAlbumId();
            return ResponseResult.success().data("album_id",albumId);
        }catch (Exception e){
            logger.error("error    /album/update    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //相册删除接口
    @RequestMapping("/album/delete/{id}")
    public Object deleteAlbum(@PathVariable(value = "id") Integer id){
        try {
            logger.info("info    /album/delete/id    {}",id);
            albumService.deleteAlbum(id);
            return ResponseResult.success();
        }catch (Exception e){
            logger.error("error     /album/delete/id   {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }

    //查询所有相册
    @RequestMapping("/album/select/all")
    public Object selectAlbumAll(){
        try {

            ArrayList<AlbumDO> albumDOS = albumService.selectAlbumAll();
            return ResponseResult.success().data("news_size",albumDOS.size()).data("news_data",albumDOS);
        }catch (Exception e){
            logger.error("error    /album/select/all    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }

    //查询具体某一个相册的所有图片
    @RequestMapping("/album/picture/url/{id}")
    public Object selectAlbumImg(@PathVariable("id") Integer id){
        try {
            ArrayList<WallPictureDO> wallPictureDOS = albumService.selectAlbumImg(id);
            return ResponseResult
                    .success()
                    .data("wall_picture_size",wallPictureDOS.size())
                    .data("wall_picture_url",wallPictureDOS);
        }catch (Exception e){
            logger.error("error   /album/picture/url/id   {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }

    }
    //新增相册图片记录
    @RequestMapping("/album/picture/add")
    public Object insertAlbumPicture(@RequestBody WallPictureDO wallPictureDO){
        try {
            logger.info("info    /album/picture/add    {}",wallPictureDO.toString());
            albumService.insertAlbumPicture(wallPictureDO);
            return ResponseResult.success().data("wall_picture_id",wallPictureDO.getWallPictureId());
        }catch (Exception e){
            logger.error("error    /album/picture/add    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //删除相册中的图片记录 id号为相册图片的id编号
    @RequestMapping("/album/picture/delete/{id}")
    public Object deleteAlbumPicture(@PathVariable("id") Integer id){
        try {
            albumService.deleteAlbumPicture(id);
            return ResponseResult.success();
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
    //修改相册中的图片记录 id号为相册图片的id号
    @RequestMapping("/album/picture/update")
    public Object updateAlbumPicture(@RequestBody WallPictureDO wallPictureDO){
        try{
            albumService.updateAlbumPicture(wallPictureDO);
            return ResponseResult.success().data("wall_picture_id",wallPictureDO.getWallPictureId());
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
}
