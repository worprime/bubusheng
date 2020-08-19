package cn.com.chinahitech.bubusheng.teacher.controller;


import cn.com.chinahitech.bubusheng.teacher.entity.Course;
import cn.com.chinahitech.bubusheng.teacher.entity.MyStudentinfo;
import cn.com.chinahitech.bubusheng.teacher.service.InfoService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService info;

    @RequestMapping(value = "/studentinfo/{id}",method = RequestMethod.GET)
    public String getStudent(@PathVariable("id") int id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {

            List<MyStudentinfo> stuinfo=info.statisticStuInfo(id);
            map.put("status",200);
            map.put("data",stuinfo);
        }catch (Exception ex){
            map.put("status",500);
            map.put("errorMsg",ex);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/classstudent/{classid}/{teacherid}",method = RequestMethod.GET)
    public String getStudentByClass(@PathVariable("classid") int classid,@PathVariable("teacherid") int teacherid){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            List<MyStudentinfo> stuinfo=info.findStuInfoByClassid(classid,teacherid);
                map.put("status",200);
                map.put("data",stuinfo);
        }catch (Exception e){
            map.put("status",500);
            map.put("errorMsg",e);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/studentclass/{name}/{teacherid}",method = RequestMethod.GET)
    public String getStudentByName(@PathVariable("name") String stuname,@PathVariable("teacherid") int teacherid){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            List<MyStudentinfo> stuinfo=info.findStuInfoByName(stuname,teacherid);
            map.put("status",200);
            map.put("data",stuinfo);
        }catch (Exception e){
            map.put("status",500);
            map.put("errorMsg",e);
        }
        return JSON.toJSONString(map);
    }
}

