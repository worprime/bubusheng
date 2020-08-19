package cn.com.chinahitech.bubusheng.student.controller;


import cn.com.chinahitech.bubusheng.student.entity.StCourseData;
import cn.com.chinahitech.bubusheng.student.entity.StStudent;
import cn.com.chinahitech.bubusheng.student.service.StIStudentService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * @since 2020-08-10
 */
@RestController
@CrossOrigin
@RequestMapping("/student/student")
public class StStudentController {
    @Autowired

    private StIStudentService studentService;
    //1.注册（用到了）
    @RequestMapping(value="/insertStudent",method = RequestMethod.GET)
    public String insertStudent(String stuName,String sex,Integer age,String password,String phone){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success=studentService.insertStudent(stuName,sex,age,password,phone);
        map.put("status","200");
        map.put("data",success);
        return JSON.toJSONString(map);
    }
    //2.更改个人信息(用到了)
    @RequestMapping(value="/updateStudent",method = RequestMethod.GET)
    public boolean updateStudent(Integer stuId,String stuName,String sex,Integer age,String password,String phone){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success=studentService.updateStudent(stuId,stuName,sex,age,password,phone);
        return success;
    }

    //3.根据课程id查找视频的路径
    @RequestMapping(value="/findPathByClassId",method = RequestMethod.GET)
    public String findPathByClassId(Integer classId){
        Map<String,Object> map = new HashMap<String,Object>();
        String result=studentService.findPathByClassId(classId);
        map.put("status","200");
        map.put("data",result);
        return result;
    };
    //4.利用手机号查找学生ID（用到了）
    @RequestMapping(value="/getStudentById",method = RequestMethod.GET)
    public String getStudentId(String phone){
        Map<String,Object> map = new HashMap<String,Object>();
        int id=studentService.getStudentId(phone);
        map.put("status","200");
        map.put("data",id);
        return JSON.toJSONString(map);
    }

    //5.查询学生的所有信息(用到了)
    @RequestMapping(value="/getAllStudent",method = RequestMethod.GET)
    public String getAllStudent(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        StStudent student=studentService.getAllStudent(id);
        map.put("status", 200);
        map.put("data", student);
        return JSON.toJSONString(map);
    }

    //6.模糊查询学生列表
    @RequestMapping(value="/getStudentKey",method = RequestMethod.POST)
    public String getStudentKey(String keyword) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<StStudent> list=studentService.getStudentKey(keyword);
        map.put("status", 200);
        map.put("data", list);
        return JSON.toJSONString(map);
    }

    //7.恢复为活动状态
    @RequestMapping(value="/revertStudent",method = RequestMethod.POST)
    public String revertStudent(int uid) {
            Map<String, Object> map = new HashMap<String, Object>();
            int success = studentService.revertStudent(uid);
            if(success!=-1) {
                map.put("status", 200);
                map.put("data", success);
                return JSON.toJSONString(map);
            }
            return JSON.toJSONString(map);
    }

    //8.登录（用到了）
    @RequestMapping(value="/loginByAccoutAndPassword",method = RequestMethod.GET)
    public String loginByAccoutAndPassword(String phone, String password){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success=studentService.loginByAccoutAndPassword(phone,password);
        if(success==true)
            map.put("status",200);
        else
            map.put("status",400);
        map.put("data",success);
        return JSON.toJSONString(map);
    }

    //9.根据学生登录名来查找学生
    @RequestMapping(value="/findStudentByAccount",method = RequestMethod.POST)
    public String findStudentByAccount(String account){
        Map<String,Object> map = new HashMap<String,Object>();
        List<StStudent> studentList = studentService.findStudentByAccount(account);
        map.put("status",200);
        map.put("data",studentList);
        return JSON.toJSONString(map);
    }

}
