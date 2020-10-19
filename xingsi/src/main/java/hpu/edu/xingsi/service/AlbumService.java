package hpu.edu.xingsi.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import hpu.edu.xingsi.mapper.AlbumMapper;
import hpu.edu.xingsi.pojo.AlbumDO;
import hpu.edu.xingsi.pojo.AlbumDTO;
import hpu.edu.xingsi.pojo.WallPictureDO;
import hpu.edu.xingsi.util.ImageDeleteUtil;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.ObjectName;
import java.util.ArrayList;


/**
 * @author zhou'en'xian
 * @date 2020/9/3  17:47
 */
@Service
public class AlbumService {
    @Resource
    private AlbumMapper albumMapper;
    @Resource
    private ImageDeleteUtil imageDeleteUtil;
    //新建相册
    public int insertAlbum(AlbumDTO albumDTO){
        return  albumMapper.insertAlbum(albumDTO);
    }

    //更新相册
    public int updateAlbum(AlbumDO albumDO){
        return albumMapper.updateAlbum(albumDO);
    }

    //删除相册
    public int deleteAlbum(Integer id){
//            //查找相册缩略图url地址
//            String url=albumMapper.selectAlbumThumbUrl(id);
//            //判断相册是否设置了缩略图,有则删除
//            if(url!=null){
//                //解析相对地址
//                StorePath storePath = StorePath.parseFromUrl(url);
//                //删除相册缩略图
//                imageDeleteUtil.imgDelete(storePath.getFullPath());
//            }
//            //查找相册中包含的图片的url地址
//            ArrayList<String> arrayList = albumMapper.selectAlbumImgUrl(id);
//            //判断相册中是否包含图片
//            if(arrayList.size()!=0){
//                for (String s : arrayList) {
//                    //解析图片url
//                    String fullPath = StorePath.parseFromUrl(s).getFullPath();
//                    //删除相册中的图片
//                    imageDeleteUtil.imgDelete(fullPath);
//                }
//            }
//
            //删除数据库中的相册记录
            return albumMapper.deleteAlbum(id);

    }

    //查询所有相册
    public ArrayList<AlbumDO> selectAlbumAll(){

        return  albumMapper.selectAlbumAll();
    }

    //查询具体的相册中的所有的图片
    public ArrayList<WallPictureDO> selectAlbumImg(Integer id){
        return albumMapper.selectAlbumImg(id);
    }
    //增加相册中的图片
    public Object insertAlbumPicture(WallPictureDO wallPictureDO){
        return albumMapper.insertAlbumPicture(wallPictureDO);
    }
    //删除某一个具体相册中的图片以及数据库记录
    public void deleteAlbumPicture(Integer id){

        albumMapper.deleteAlbumPicture(id);
    }
    //修改某一个具体相册中的图片以及数据库记录
    public  void updateAlbumPicture(WallPictureDO wallPictureDO){
         albumMapper.updateAlbumPicture(wallPictureDO);
    }
}
