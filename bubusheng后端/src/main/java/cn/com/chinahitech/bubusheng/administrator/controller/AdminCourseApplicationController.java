package cn.com.chinahitech.bubusheng.administrator.controller;


import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourseApplication;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminCourseApplicationService;
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
public class AdminCourseApplicationController {

    @Autowired
    private IAdminCourseApplicationService courseapplicationService;

    @RequestMapping("/getAllAudit")
    public String getAllAudit(Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourseApplication> adminCourseApplicationPage = courseapplicationService.getAllAduit(currentPage,limit);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplicationPage.getRecords());
            map.put("total",adminCourseApplicationPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getAuditById")
    public String getAuditById(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        AdminCourseApplication adminCourseApplication = courseapplicationService.getAduitById(id);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplication);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getAuditByKey")
    public String getAuditByKey(String key,String keyword,Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourseApplication> adminCourseApplicationPage = courseapplicationService.getAduitByKey(currentPage,limit,key,keyword);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplicationPage.getRecords());
            map.put("total",adminCourseApplicationPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/SubmitAudit")
    public String submitAudit(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            courseapplicationService.sumbitAduit(id);
            map.put("status",200);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/unSubmitAudit")
    public String unsubmitAudit(String id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            courseapplicationService.unsumbitAduit(id);
            map.put("status",200);
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }


    @RequestMapping("/getFinishedAudit")
    public String getFinishedAudit(Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourseApplication> adminCourseApplicationPage = courseapplicationService.getFinishedAduit(currentPage,limit);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplicationPage.getRecords());
            map.put("total",adminCourseApplicationPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getFinishedAuditByKey")
    public String getFinishedAuditByKey(String key,String keyword,Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourseApplication> adminCourseApplicationPage = courseapplicationService.getFinishedAduitByKey(currentPage,limit,key,keyword);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplicationPage.getRecords());
            map.put("total",adminCourseApplicationPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getDealAudit")
    public String getDealAudit(Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourseApplication> adminCourseApplicationPage = courseapplicationService.getDealAduit(currentPage,limit);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplicationPage.getRecords());
            map.put("total",adminCourseApplicationPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/getDealAuditByKey")
    public String getDealAuditByKey(String key,String keyword,Integer currentPage,Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminCourseApplication> adminCourseApplicationPage = courseapplicationService.getDealAduitByKey(currentPage,limit,key,keyword);
        try{
            map.put("status",200);
            map.put("data", adminCourseApplicationPage.getRecords());
            map.put("total",adminCourseApplicationPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        return JSON.toJSONString(map);
    }

}
