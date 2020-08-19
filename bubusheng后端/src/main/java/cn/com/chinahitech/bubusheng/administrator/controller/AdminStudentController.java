package cn.com.chinahitech.bubusheng.administrator.controller;


import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudent;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminStudentService;
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
public class AdminStudentController {
    @Autowired
    private IAdminStudentService adminStudentService;

    @RequestMapping("/getAllStudent")
    public String getAllCourse(Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminStudent> studentPage =adminStudentService.getAllStudent(currentPage,limit);
        try{
            map.put("status",200);
            map.put("data",studentPage.getRecords());
            map.put("total",studentPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }
    @RequestMapping("/getStudentById")
    public String getStudentById(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        AdminStudent adminStudent =adminStudentService.getStudentById(id);
        try{
            map.put("status",200);
            map.put("data",adminStudent);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getStudentByKey")
    public String getStudentByKey(String key,String keyword,Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminStudent> adminStudentPage = adminStudentService.getStudentByKey(currentPage,limit,key,keyword);
        try{
            map.put("status",200);
            map.put("data", adminStudentPage.getRecords());
            map.put("total",adminStudentPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        adminStudentService.deleteStudent(id);
        try{
            map.put("status",200);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }
}
