package hpu.edu.xingsi.service;

import hpu.edu.xingsi.mapper.ImageUploadMapper;
import hpu.edu.xingsi.pojo.AlbumImgDTO;
import hpu.edu.xingsi.pojo.CacheImgDTO;
import hpu.edu.xingsi.pojo.SwiperImgDTO;
import hpu.edu.xingsi.util.ImageUploadUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * @author zhou'en'xian
 * @date 2020/9/4  17:31
 */
@Service
public class ImageUploadService {
    @Resource
    private ImageUploadMapper imageUploadMapper;
    @Resource
    private ImageUploadUtil imageUploadUtil;
    public int swiperImgUpload(SwiperImgDTO swiperImgDTO){
        CacheImgDTO cacheImgDTO=new CacheImgDTO(null,swiperImgDTO.getSwiperPictureUrl(),"swiper");
        imageUploadMapper.cacheImgUpload(cacheImgDTO);
        return imageUploadMapper.swiperImgUpload(swiperImgDTO);
    }
    public HashMap<String, String> newsImgUpload(MultipartFile multipartFile) throws IOException {
        //调用imageUploadUtil中的方法，实现图片的上传
        HashMap<String, String> stringHashMap = imageUploadUtil.imagesUpload(multipartFile);
        //封装bean
        CacheImgDTO cacheImgDTO =new CacheImgDTO(null,stringHashMap.get("url"),"news");
        //将图片url插入到数据库中
        int id=imageUploadMapper.cacheImgUpload(cacheImgDTO);
        return stringHashMap;
    }
    public HashMap<String,String>newsImgThumbUpload(MultipartFile file) throws IOException {
        //调用imageUploadUtil中的方法，实现图片的上传
        HashMap<String, String> stringHashMap = imageUploadUtil.imagesUpload(file);
       //封装bean
        CacheImgDTO cacheImgDTO =new CacheImgDTO(null,stringHashMap.get("url"),"news_thumb");
        //将图片url插入到数据库，以记录
        imageUploadMapper.cacheImgUpload(cacheImgDTO);
        return stringHashMap;
    }
    //相册缩略图上传接口
    public  HashMap<String ,String> albumImgThumbUpload(MultipartFile file) throws IOException {
        //将图片储存到fastdfs中
        HashMap<String, String> stringHashMap = imageUploadUtil.imagesUpload(file);
        CacheImgDTO cacheImgDTO =new CacheImgDTO(null,stringHashMap.get("url"),"album_thumb");
        //在数据库中记录图片地址
        imageUploadMapper.cacheImgUpload(cacheImgDTO);
        return stringHashMap;
    };
    //相册中的图片上传接口
    public HashMap<String,String >albumImgUpload(MultipartFile file) throws IOException {
        //将图片上传到fastdfs中
        HashMap<String, String> stringHashMap = imageUploadUtil.imagesUpload(file);
        AlbumImgDTO albumImgDTO=new AlbumImgDTO();
        albumImgDTO.setImgStorageUrl(stringHashMap.get("url"));
        //数据库中记录图片地址
        imageUploadMapper.cacheImgUpload(new CacheImgDTO(null,stringHashMap.get("url"),"album_img"));
       // imageUploadMapper.albumImgUpload(albumImgDTO);
        return stringHashMap;
    }
}
