package hpu.edu.xingsi.service;

import hpu.edu.xingsi.mapper.ImageDeleteMapper;
import hpu.edu.xingsi.util.ImageDeleteUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhou'en'xian
 * @date 2020/9/10  17:37
 */
@Service
public class ImageDeleteService {
    @Resource
    private ImageDeleteMapper imageDeleteMapper;
    @Resource
    private ImageDeleteUtil imageDeleteUtil;

    public void imageDeleteSwiper(String url){
        imageDeleteUtil.imgDelete(url);
        imageDeleteMapper.imageDeleteSwiper(url);
    };
    public  void imageDeleteAlbumImg(String url){
        imageDeleteUtil.imgDelete(url);
        imageDeleteMapper.imageDeleteAlbumImg(url);
    };
}
