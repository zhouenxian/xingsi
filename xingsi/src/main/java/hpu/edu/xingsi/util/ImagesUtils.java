package hpu.edu.xingsi.util;

import net.coobird.thumbnailator.Thumbnails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author zhou'en'xian
 * @date 2020/10/11  19:44
 */
@Component
public class ImagesUtils {
    private static final Logger logger= LoggerFactory.getLogger(ImagesUtils.class);
    private static final Long MAX_IMAGE_SIZE=50*1024L;
    public static byte[] compressImageForScale(byte[]imageBytes){
        try {
            if(imageBytes.length<=0||imageBytes.length<MAX_IMAGE_SIZE){
                return imageBytes;
            }
            long srcSize=imageBytes.length;
            double accuracy = getAccuracy(srcSize/1024);
            if (imageBytes.length>MAX_IMAGE_SIZE){
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(imageBytes.length);
                Thumbnails.of(byteArrayInputStream)
                          .scale(1f)
                          .outputQuality(accuracy)
                          .toOutputStream(byteArrayOutputStream);
                imageBytes=byteArrayOutputStream.toByteArray();
            }
            return imageBytes;
        }catch (Exception e){
            logger.error("压缩图片出错：{}",e.getLocalizedMessage(),e);
        }
        return imageBytes;
    }
    private static double getAccuracy(long size){
        double accuracy;
        if(size<=100){
            accuracy=0.24;
        }else {
            accuracy=0.2;
        }
        return accuracy;
    }
}
