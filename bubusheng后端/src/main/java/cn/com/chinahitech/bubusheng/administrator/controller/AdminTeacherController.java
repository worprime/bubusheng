package cn.com.chinahitech.bubusheng.administrator.controller;


import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourse;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminTeacher;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminCourseService;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminTeacherService;
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
 * @since 2020-08-12
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminTeacherController {
    @Autowired
    private IAdminTeacherService adminTeacherService;

    @Autowired
    private IAdminCourseService adminCourseService;

    @RequestMapping("/getAllTeacher")
    public String getAllTeacher(Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminTeacher> teacherPage =adminTeacherService.getAllTeacher(currentPage,limit);
        try{
            map.put("status",200);
            map.put("data",teacherPage.getRecords());
            map.put("total",teacherPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getTeacherById")
    public String getTeacherById(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        AdminTeacher adminTeacher =adminTeacherService.getTeacherById(id);
        try{
            map.put("status",200);
            map.put("data",adminTeacher);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getTeacherByKey")
    public String getTeacherByKey(String key,String keyword,Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminTeacher> adminTeacherPage = adminTeacherService.getTeacherByKey(currentPage,limit,key,keyword);
        try{
            map.put("status",200);
            map.put("data", adminTeacherPage.getRecords());
            map.put("total",adminTeacherPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getCourseByTeacherId")
    public String getCourseByTeacherId(Integer currentPage,Integer limit,String id){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourse> adminCoursePage = adminCourseService.getCourseByTeacherId(currentPage,limit,id);
        try{
            map.put("status",200);
            map.put("data", adminCoursePage.getRecords());
            map.put("total",adminCoursePage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }
    @RequestMapping("/deleteTeacher")
    public String deleteTeacher(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        adminTeacherService.deleteTeacher(id);
        try{
            map.put("status",200);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

}
