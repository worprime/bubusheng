package cn.com.chinahitech.bubusheng.teacher.controller;


import cn.com.chinahitech.bubusheng.teacher.entity.Course;
import cn.com.chinahitech.bubusheng.teacher.service.TeaICourseService;
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
@RequestMapping("/course")
public class TeaCourseController {
    @Autowired
    private TeaICourseService cour;


    @RequestMapping(value = "/show/{id}",method = RequestMethod.GET)
    public String getCourse(@PathVariable("id") int id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            List<Course> coursesinfo=cour.showCourse(id);
            map.put("status",200);
            map.put("data",coursesinfo);
        }catch (Exception ex){
            map.put("status",500);
            map.put("errorMsg","err");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public String findCourse(@PathVariable("id") int id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Course coursesinfo=cour.findCourse(id);
            map.put("status",200);
            map.put("data",coursesinfo);
        }catch (Exception ex){
            map.put("status",500);
            map.put("errorMsg","err");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/like/{name}/{teaid}",method = RequestMethod.GET)
    public String findCourselike(@PathVariable("name") String name,@PathVariable("teaid") Integer teaid){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            List<Course> coursesinfo=cour.findCourselike(name,teaid);
            map.put("status",200);
            map.put("data",coursesinfo);
        }catch (Exception ex){
            map.put("status",500);
            map.put("errorMsg","err");
        }
        return JSON.toJSONString(map);
    }

}
