package hpu.edu.xingsi.service;

import hpu.edu.xingsi.mapper.MyNewsPictureInsertMapper;
import hpu.edu.xingsi.pojo.NewsPictureDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhou'en'xian
 * @date 2020/9/2  20:58
 */
@Service
public class NewsPictureInsertService {
    @Resource
    private MyNewsPictureInsertMapper myNewsPictureInsertMapper;
    public int insertNewsImg(NewsPictureDTO newsPictureDTO){
        return myNewsPictureInsertMapper.insert(newsPictureDTO);
    };
}
