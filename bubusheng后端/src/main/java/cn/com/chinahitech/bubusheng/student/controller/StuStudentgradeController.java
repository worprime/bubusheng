package cn.com.chinahitech.bubusheng.student.controller;


import cn.com.chinahitech.bubusheng.student.entity.CourseGrade;
import cn.com.chinahitech.bubusheng.student.entity.CourseTest;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentclassService;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentgradeService;
import cn.com.chinahitech.bubusheng.student.service.impl.StuStudentgradeServiceImpl;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.management.snmp.jvminstr.JvmOSImpl;

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
public class StuStudentgradeController {

    @Autowired
    private StuIStudentgradeService stuIStudentgradeService;

    @Autowired
    private StuIStudentclassService stuIStudentclassService;


    @RequestMapping(value = "/studentJoinClass",method = RequestMethod.GET)
    public String studentJoinClass(int stuId, int classId)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        boolean hasJoinClass = stuIStudentgradeService.hasJoinClass(stuId,classId);

        try
        {
            if(!hasJoinClass)
            {
                stuIStudentgradeService.studentJoinClass(stuId,classId);
                stuIStudentclassService.studentJoinClass(stuId,classId);
                map.put("status",200);
            }
            else //课程已加入
            {
                map.put("status",201);
            }
        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/getCourseGradeByStuId",method = RequestMethod.GET)
    public String getCourseGradeByStuId(int Stuid)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        try
        {
            List<CourseGrade> courseGradeList = stuIStudentgradeService.getCourseGradeByStuid(Stuid);
            map.put("status","200");
            map.put("gradesData",courseGradeList);
        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }


    @RequestMapping(value = "/getCourseTestByStuid",method = RequestMethod.GET)
    public String getCourseTestByStuid(int Stuid)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        try
        {
            List<CourseTest> courseTests = stuIStudentgradeService.getCourseTestByStuid(Stuid);
            map.put("status","200");
            map.put("testData",courseTests);
        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/getCourseGradeByStuIdClassId",method = RequestMethod.GET)
    public String getCourseGradeByStuIdClassId(int StuId, String ClassName)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        try
        {
            List<CourseGrade> courseGrades = stuIStudentgradeService.getCourseGradeByStuIdClassName(StuId,ClassName);
            map.put("status","200");
            map.put("gradesData",courseGrades);
        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
