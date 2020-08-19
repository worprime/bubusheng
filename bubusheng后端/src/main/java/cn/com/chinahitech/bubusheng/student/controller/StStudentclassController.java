package cn.com.chinahitech.bubusheng.student.controller;
import cn.com.chinahitech.bubusheng.student.entity.StStudent;
import cn.com.chinahitech.bubusheng.student.service.StIStudentclassService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
@RequestMapping("/student/studentclass")
public class StStudentclassController {

    @Autowired
    private StIStudentclassService studentclassService;

    //1.为新增学生课程
    @RequestMapping(value="/insertStudentClass",method = RequestMethod.POST)
    public String insertStudentClass(int  stuId, int classId){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success=studentclassService.insertStudentClass(stuId,classId);
        map.put("status", 200);
        map.put("data", success);
        return JSON.toJSONString(map);
    }

    //2.删除学生的选课
    @RequestMapping(value="/deleteStudentClass",method = RequestMethod.POST)
    public String deleteStudentClass(int stuId, int classId){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean success=studentclassService.deleteStudentClass(stuId,classId);
        map.put("status", 200);
        map.put("data", success);
        return JSON.toJSONString(map);
    }

    //4.根据课程id查询所有学生
    @RequestMapping(value="/getClassStudent",method = RequestMethod.POST)
    public String getClassStudent(int classId) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<StStudent> result=studentclassService.getClassStudent(classId);
        if(result==null){
            return "no courses that the user selected";
        }
        map.put("status", 200);
        map.put("data", result);
        return JSON.toJSONString(map);
    }
}
