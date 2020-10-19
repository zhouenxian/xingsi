package hpu.edu.xingsi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hpu.edu.xingsi.mapper.HistoryMapper;
import hpu.edu.xingsi.mapper.HistoryPersonBaseMapper;
import hpu.edu.xingsi.mapper.HistoryYearBaseMapper;
import hpu.edu.xingsi.pojo.HistoryPersonDO;
import hpu.edu.xingsi.pojo.HistoryPersonDTO;
import hpu.edu.xingsi.pojo.HistoryYearDO;
import hpu.edu.xingsi.pojo.HistoryYearDTO;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhou'en'xian
 * @date 2020/9/6  11:11
 */
@Service
public class HistoryService {
    @Resource
    private HistoryPersonBaseMapper historyPersonBaseMapper;
    @Resource
    private HistoryYearBaseMapper historyYearBaseMapper;
    @Resource
    private HistoryMapper historyMapper;
    //年份新增接口
    public Integer insertHistoryYear(HistoryYearDTO historyYearDTO){
        return historyMapper.insertHistory(historyYearDTO);
    }
    //人物新增接口
    public Integer insertHistoryPerson(HistoryPersonDO historyPersonDO){
        int insert = historyPersonBaseMapper.insert(historyPersonDO);
        return insert;
    }

    //根据人物id编号删除单个人物
    public Integer historyPersonDeleteByPersonId(Integer id){

        return historyMapper.historyPersonDeleteByPersonId(id);
    }
    //年份删除接口
    public Integer deleteHistoryYear(Integer id){
        return historyMapper.deleteHistoryYear(id);
    }

    //年份修改接口
    public Object updateHistoryYearByYearId(HistoryYearDO historyYearDO){
        return historyYearBaseMapper.updateById(historyYearDO);
    }
    //查询出所有的行思历史年份
    public List<HistoryYearDO> selectHistoryYearAll(){
        return historyYearBaseMapper.selectList(new QueryWrapper<HistoryYearDO>());
    }
    //根据id查询出一个年份记录
    public HistoryYearDO selectHistoryById(Integer id){
        return historyYearBaseMapper.selectById(id);
    }
    //分页查询年份记录
    public Object selectHitoryByPage(Integer page,Integer limit){
        QueryWrapper<HistoryYearDO> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("history_year_id");
        Page<HistoryYearDO> pages=new Page<>(page,limit);
        IPage<HistoryYearDO>iPage=historyYearBaseMapper.selectMapsPage((Page)pages,queryWrapper);
        return iPage;
    }
    //分页查询所有行思人物
    public Object selectHistoryPersonPage(Integer page,Integer limit){
        QueryWrapper<HistoryPersonDO> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("weight");
        Page<HistoryPersonDO> objectPage = new Page<>(page,limit);
        IPage<HistoryPersonDO>iPage=historyPersonBaseMapper.selectPage(objectPage,queryWrapper);
        return iPage;
    }
    //根据年份id查询该年份内的所有人物
    public Object selectHistoryPersonByYearId(Integer id){
        QueryWrapper<HistoryPersonDO> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("year_id",id).orderByDesc("weight");
        return historyPersonBaseMapper.selectList(queryWrapper);
    }
    //行思历史人物修改
    public Integer updateHistoryPerson(HistoryPersonDO historyPersonDO){
        return historyPersonBaseMapper.updateById(historyPersonDO);
    }
}
