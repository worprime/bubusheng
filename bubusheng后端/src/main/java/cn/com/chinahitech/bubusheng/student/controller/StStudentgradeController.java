package cn.com.chinahitech.bubusheng.student.controller;


import cn.com.chinahitech.bubusheng.student.entity.StStudentgrade;
import cn.com.chinahitech.bubusheng.student.service.StIStudentgradeService;
import com.alibaba.fastjson.JSON;
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
@RequestMapping("/student/studentgrade")
public class StStudentgradeController {

    @Autowired
    private StIStudentgradeService studentgradeService;

    //1.添加学生分数
    @RequestMapping(value="/insertStudentGrade",method = RequestMethod.POST)
    public String insertStudentGrade(int stuId,int classId,int score){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean i=studentgradeService.insertStudentGrade(stuId,classId,score);
        map.put("status", 200);
        map.put("data", i);
        return JSON.toJSONString(map);
    };

    //2.更改学生分数
    @RequestMapping(value="/updateStudentGrade",method = RequestMethod.POST)
    public String updateStudentGrade(int stuId,int classId,int score){
        Map<String,Object> map = new HashMap<String,Object>();
        boolean i=studentgradeService.updateStudentGrade(stuId,classId,score);
        map.put("status", 200);
        map.put("data", i);
        return JSON.toJSONString(map);
    };

    //3.根据id和课程查询分数
    @RequestMapping(value="/findStudentGradeById",method = RequestMethod.POST)
    public String findStudentGradeById(String classId,String studentId){
        Map<String,Object> map = new HashMap<String,Object>();
        int score=studentgradeService.findStudentGradeById(classId,studentId);
        map.put("status", 200);
        map.put("data",score);
        return JSON.toJSONString(map);
    }

    //4.根据课程id查询成绩
    @RequestMapping(value="/findStudentGradeByClassId",method = RequestMethod.POST)
    public String findStudentGradeByClassId(int classId){
        Map<String,Object> map = new HashMap<String,Object>();
        List<StStudentgrade> result=studentgradeService.findStudentGradeByClassId(classId);
        map.put("status", 200);
        map.put("data",result);
        return JSON.toJSONString(map);
    }

    //5.根据学生id查找分数
    @RequestMapping(value="/getStudentGrade",method = RequestMethod.POST)
    public String getStudentGrade(int stuId){
        Map<String,Object> map = new HashMap<String,Object>();
        List<StStudentgrade> result=studentgradeService.getStudentGrade(stuId);
        map.put("status", 200);
        map.put("data",result);
        return JSON.toJSONString(map);
    }
}
