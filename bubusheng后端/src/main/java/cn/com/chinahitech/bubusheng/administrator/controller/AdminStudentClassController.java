package cn.com.chinahitech.bubusheng.administrator.controller;


import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClassVo;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminStudentClassService;
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
@RestController("adminStudentclassController")
@RequestMapping("/admin")
@CrossOrigin
public class AdminStudentClassController {
    @Autowired
    private IAdminStudentClassService adminStudentClassService;

    @RequestMapping("/getStudentByClass")
    public String getStudentClass(Integer currentPage,Integer limit,String id){
        Map<String,Object> map = new HashMap<String,Object>();
        IPage<AdminStudentClassVo> adminStudentClassVoPage =adminStudentClassService.getClassStudent(currentPage,limit,id);
        try{
            map.put("status",200);
            map.put("data",adminStudentClassVoPage.getRecords());
            map.put("total",adminStudentClassVoPage.getTotal());
        }catch (Exception e){
            map.put("status",500);
        }
        System.out.println(JSON.toJSONString(map));
        return JSON.toJSONString(map);
    }
}
