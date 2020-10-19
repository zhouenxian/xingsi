package hpu.edu.xingsi.task;


import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import hpu.edu.xingsi.mapper.GarbageCleaningMapper;
import hpu.edu.xingsi.util.ImageDeleteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


/**
 * @author zhou'en'xian
 * @date 2020/9/29  20:53
 */
@Component
public class GarbageCleanTask {
    @Resource
    private GarbageCleaningMapper garbageCleaningMapper;
    @Resource
    private ImageDeleteUtil imageDeleteUtil;


    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Scheduled(cron = "0 0 * * * *")
    public void GarbageCleaning(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        logger.info("{}:垃圾清理",simpleDateFormat.format(new Date(System.currentTimeMillis())));
        try {
            AlbumDfsAndDBGarbageCleaning();
            newsDfsAndDBGarbageCleaning();
        }catch (Exception e){
            logger.error("垃圾清理时出现异常:{}",e.getLocalizedMessage(),e);
        }
    }
    //清理wall_picture图片
    public void AlbumDfsAndDBGarbageCleaning(){
        List<String> list = garbageCleaningMapper.wallPictureCleaning();
        if(list.size()!=0) {
            logger.info("清理的相册图片：{}",list);
            for (String url : list) {
                StorePath storePath = StorePath.parseFromUrl(url);
                garbageCleaningMapper.deleteWallPicture(url);
                imageDeleteUtil.imgDelete(storePath.getFullPath());
            }
        }
    }
    public void newsDfsAndDBGarbageCleaning(){
        List<String> list = garbageCleaningMapper.newsImgCleaning();
        if(list.size()!=0){
            logger.info("清理的新闻图片：{}",list);
            for(String url:list){
                StorePath storePath=StorePath.parseFromUrl(url);
                garbageCleaningMapper.deleteNewsImg(url);
                imageDeleteUtil.imgDelete(storePath.getFullPath());
            }
        }

    }

}
