package hpu.edu.xingsi.util;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import hpu.edu.xingsi.Enum.ServerUrlEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

/**
 * 该类用于操作fastdfs储存图片,并返回图片名与图片完整路径
 */

@Component
public class ImageUploadUtil {
    @Resource
    private FastFileStorageClient fastFileStorageClient;
//    private Logger logger= LoggerFactory.getLogger(ImagesUtils.class);
    public HashMap<String, String> imagesUpload(MultipartFile multipartFile) throws IOException {
        byte[] bytes = multipartFile.getBytes();
        byte[] by = ImagesUtils.compressImageForScale(bytes);
        InputStream inputStream = new ByteArrayInputStream(by);
        //获取文件的后缀名,判断文件类型
        String extName= multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf('.')+1);
        //上传文件
        StorePath storePath = fastFileStorageClient.uploadFile(inputStream, by.length, extName, null);
        //封装文件上传成功后的信息
        HashMap<String,String>map=new HashMap<>();
        map.put("name",storePath.getFullPath());
        map.put("url", ServerUrlEnum.SERVER_URL_ENUM.getUrl()+storePath.getFullPath());
        return map;
    }
}
