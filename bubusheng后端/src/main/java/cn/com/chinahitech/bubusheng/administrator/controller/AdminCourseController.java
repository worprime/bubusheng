package cn.com.chinahitech.bubusheng.administrator.controller;


import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourse;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminCourseService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminCourseController {

    @Autowired
    private IAdminCourseService adminCourseService;

    @RequestMapping("/getAllCourse")
    public String getAllCourse(Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourse> courseListPage =adminCourseService.getAllCourse(currentPage,limit);
        try{
            map.put("status",200);
            map.put("data",courseListPage.getRecords());
            map.put("total",courseListPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getCourseById")
    public String getCourseById(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        AdminCourse course =adminCourseService.getCourseById(id);
        try{
            map.put("status",200);
            map.put("data",course);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getCourseByKey")
    public String getCourseByKey(String key,String keyword,Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourse> adminCoursePage = adminCourseService.getCourseByKey(currentPage,limit,key,keyword);
        try{
            map.put("status",200);
            map.put("data", adminCoursePage.getRecords());
            map.put("total",adminCoursePage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }
}
