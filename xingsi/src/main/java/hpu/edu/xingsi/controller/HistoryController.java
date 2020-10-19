package hpu.edu.xingsi.controller;


import hpu.edu.xingsi.pojo.HistoryPersonDO;
import hpu.edu.xingsi.pojo.HistoryYearDO;
import hpu.edu.xingsi.pojo.HistoryYearDTO;
import hpu.edu.xingsi.service.HistoryService;
import hpu.edu.xingsi.util.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhou'en'xian
 * @date 2020/9/6  11:18
 */
@RestController
public class HistoryController {
    private final Logger logger = LoggerFactory.getLogger(HistoryController.class);
    @Resource
    private HistoryService historyService;

    //行思历史年份新增接口
    @RequestMapping("/history/add")
    public Object historyAdd(@RequestBody HistoryYearDTO historyYearDTO){
        try {
            logger.info("info     /history/add     {}",historyYearDTO.toString());
            historyService.insertHistoryYear(historyYearDTO);
            int yearId=historyYearDTO.getId();
            return ResponseResult.success().data("history_year_id",yearId);
        }catch (Exception e){
            logger.error("error    /history/add     {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }

    }
    //行思历史人物新增接口
    @RequestMapping("/history/add/person")
    public Object historyPersonAdd(@RequestBody HistoryPersonDO historyPersonDO){
        try {
             historyService.insertHistoryPerson(historyPersonDO);
            return ResponseResult.success().data("history_person_id",historyPersonDO.getHistoryPersonId());
        }catch (Exception e){
            logger.error("error    /history/person/add    {}",e.getLocalizedMessage(),e);
           return ResponseResult.fail();
        }
    }
    //根据人物id编号删除单个人物记录
    @RequestMapping("/history/person/delete/one/{id}")
    public Object historyPersonDeleteByPersonId(@PathVariable Integer id){
        try {
            historyService.historyPersonDeleteByPersonId(id);
            return ResponseResult.success();
        }catch (Exception e){
            logger.error("error     /history/person/delete/one/id    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //行思历史删除接口
    @RequestMapping("/history/delete/{id}")
    public Object historyDelete(@PathVariable(value = "id") Integer id){
        try {
            historyService.deleteHistoryYear(id);
            return ResponseResult.success();
        }catch (Exception e){
            logger.error("error    /history/delete/id   {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }

    }
    //行思历史年份查询全部接口
    @RequestMapping("/history/select/all")
    public Object selectHistoryYearAll(){
        try{
            List<HistoryYearDO> historyYearDOS = historyService.selectHistoryYearAll();
            return ResponseResult.success()
                    .data("histroy_year_data",historyYearDOS);
        }catch (Exception e){
            logger.error("error   /history/select/all    {}",e.getLocalizedMessage(),e);
            return ResponseResult.fail();
        }
    }
    //行思历史年份单条查询接口
    @RequestMapping("/history/select/one/{id}")
    public Object selectHistoryYearById(@PathVariable("id") Integer id){
        try{
            HistoryYearDO historyYearDO = historyService.selectHistoryById(id);
            return ResponseResult
                    .success()
                    .data("history_year_data",historyYearDO);
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
    //行思历史年份分页查询接口
    @RequestMapping("/history/select/page")
    public Object selectHistoryYearByPage(@RequestBody HashMap<String,Integer> map){
        try{
            Integer page=map.get("page");
            Integer limit=map.get("limit");
            Object o = historyService.selectHitoryByPage(page, limit);
            return ResponseResult
                    .success()
                    .data("history_year_data",o);
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
    //行思历史所有人物分页查询接口
    @RequestMapping("/history/select/all/page")
    public Object selectHistoryPersonByPage(@RequestBody Map<String,Integer>map){
        try {
            Integer page=map.get("page");
            Integer limit=map.get("limit");
            Object object = historyService.selectHistoryPersonPage(page, limit);
            return ResponseResult
                    .success()
                    .data("history_person_data",object);
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
    //根据年份id查询该年份内的所有人物
    @RequestMapping("/history/select/year/person/{id}")
    public Object selectHistoryPersonByYearId(@PathVariable("id") Integer id){
        try {
            Object o = historyService.selectHistoryPersonByYearId(id);
            return ResponseResult.success().data("history_person_data",o);
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
    //行思历史人物修改
    @RequestMapping("/history/update/person")
    public Object updateHistoryPerson(@RequestBody HistoryPersonDO historyPersonDO){
        try {
             historyService.updateHistoryPerson(historyPersonDO);
            return ResponseResult.success().data("history_person_id",historyPersonDO.getHistoryPersonId());
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
    //行思历史年份修改
    @RequestMapping("/history/update/year")
    public Object updateHistoryYearByYearId(@RequestBody HistoryYearDO historyYearDO){
        try {
            historyService.updateHistoryYearByYearId(historyYearDO);
            return ResponseResult.success().data("history_year_id",historyYearDO.getHistoryYearId());
        }catch (Exception e){
            return ResponseResult.fail();
        }
    }
}
