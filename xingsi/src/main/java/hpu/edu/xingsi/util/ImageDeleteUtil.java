package hpu.edu.xingsi.util;

import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhou'en'xian
 * @date 2020/9/1  15:02
 */
@Component
public class ImageDeleteUtil {
    private final Logger logger= LoggerFactory.getLogger(ImageDeleteUtil.class);
    @Resource
    private FastFileStorageClient fastFileStorageClient;
    public Boolean imgDelete(String imgName){
        try {
            fastFileStorageClient.deleteFile(imgName);
        }catch (Exception e){
            logger.error("fastDfs删除图片出错：{}",imgName);
        }
        return  true;
    };
}
