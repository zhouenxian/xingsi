package hpu.edu.xingsi.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import hpu.edu.xingsi.mapper.NewsMapper;
import hpu.edu.xingsi.mapper.PageNewsBaseMapper;
import hpu.edu.xingsi.pojo.NewsDO;
import hpu.edu.xingsi.pojo.NewsDTO;
import hpu.edu.xingsi.pojo.NewsPictureDTO;
import hpu.edu.xingsi.util.ImageDeleteUtil;
import hpu.edu.xingsi.util.ParseHtmlUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author zhou'en'xian
 * @date 2020/9/2  18:20
 */
@Service
public class NewsService {
    @Resource
    private ParseHtmlUtil parseHtmlUtil;
    @Resource
    private PageNewsBaseMapper pageNewsBaseMapper;
    @Resource
    private NewsMapper newsMapper;
    @Resource
    private ImageDeleteUtil imageDeleteUtil;
    //新闻上传
    public void newsInsertOneNews(NewsDTO newsDTO) {

        newsMapper.insertOneNews(newsDTO);
    }
    //新闻删除
    public void newsDelete(Integer id){

//        //查询出一条新闻中的所包含的所有图片地址
//        ArrayList<String> arrayList = newsMapper.selectNewsImg(id);
//        //判断是否为空(新闻中包含图片则删除,否则不删除)
//        if(arrayList.size()!=0){
//            for (String s : arrayList) {
//                //将完整的图片URL路径解析成相对路径
//                String fullPath = StorePath.parseFromUrl(s).getFullPath();
//                //使用ImageDeleteUtil工具类删除图片
//                imageDeleteUtil.imgDelete(fullPath);
//            }
//        }
        //查询出新闻缩略图的url路径
        String newsThumbUrl = newsMapper.selectNewsThumb(id);
        if(newsThumbUrl!=null){
            //删除新闻缩略图
            imageDeleteUtil.imgDelete(StorePath.parseFromUrl(newsThumbUrl).getFullPath());
        }
        //删除数据库中的新闻记录
        newsMapper.deleteNews(id);
//        newsMapper.deleteNewsImg(id);
    }
    //新闻修改
    public void updateNews(NewsDTO newsDTO){
        //新闻内容修改
        newsMapper.updateNews(newsDTO);
       //新闻图片url地址新增与删除
        List<String> oldImgList = newsMapper.selectNewsImgByNewsId(newsDTO.getId());
        List<String> newImgList = parseHtmlUtil.parseHtmlImg(newsDTO.getContent());
        List<String> deleteCollect = oldImgList.stream().filter(str -> !newImgList.contains(str)).collect(Collectors.toList());

        List<String> addCollect = newImgList.stream().filter(s -> !oldImgList.contains(s)).collect(Collectors.toList());

        //批量删除修改后丢弃的新闻图片地址
//        for(String url:deleteCollect){
//            StorePath storePath = StorePath.parseFromUrl(url);
//            imageDeleteUtil.imgDelete(storePath.getFullPath());
//        }
        newsMapper.deletePatchNewsImg(deleteCollect);
        //批量新增修改后新增的新闻图片
        int newsId=newsDTO.getId();
        NewsPictureDTO newsPictureDTO=new NewsPictureDTO();
        newsPictureDTO.setNewsId(newsId);
        List<NewsPictureDTO> arrayList=new ArrayList<>();
        for(String str:addCollect){
            newsPictureDTO.setImgUrl(str);
            arrayList.add(newsPictureDTO);
        }
        //批量新增应为修改而新增的图片
        newsMapper.insertPatchNewsImg(arrayList);
    }

    //根据新闻id编号查询出一条新闻内容
    public NewsDO selectNewsById(Integer id){
        return newsMapper.selectNewsById(id);
    }

    //分页查询新闻(不建议在Service中写分页查询)
    public Object selectNewsByPage(Integer page,Integer limit){
        QueryWrapper<NewsDO> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("news_id");
        Page<NewsDO> pages= new Page<>(page, limit);
        IPage<NewsDO> iPage=pageNewsBaseMapper.selectPage(pages,queryWrapper);
        return iPage;
    }
}
