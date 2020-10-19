package hpu.edu.xingsi.service;

import hpu.edu.xingsi.mapper.SearchMapper;
import hpu.edu.xingsi.pojo.NewsDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/20  21:01
 */
@Service
public class SearchService {
    @Resource
    private SearchMapper searchMapper;
    public List<NewsDO> newsSearch(String message){
        return searchMapper.newsSearch(message);
    }
}
