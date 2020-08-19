package cn.com.chinahitech.bubusheng.student.controller;


import cn.com.chinahitech.bubusheng.student.entity.StuCourse;
import cn.com.chinahitech.bubusheng.student.entity.StuStudentclass;
import cn.com.chinahitech.bubusheng.student.service.StuICourseService;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentclassService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@CrossOrigin
@RequestMapping("/student/course")
public class StuCourseController {

    @Autowired
    private StuIStudentclassService stuIStudentclassService;

    @Autowired
    private StuICourseService stuICourseService;

    @RequestMapping(value = "/getCourseInfoByStuId",method = RequestMethod.GET)
    public String getCourseInfoByStuId(int StuId)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        List<StuCourse> stuCourses = new ArrayList<StuCourse>();
        List<Integer> integers = stuIStudentclassService.getClassIdByStuid(StuId);
        stuCourses = stuIStudentclassService.getCourseByClassList(integers);
        try
        {
            int num = stuCourses.size();
            map.put("status","200");
            map.put("courses", stuCourses);
            map.put("num",num);
        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }

        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/getCourseInfoByStuIdClassName",method = RequestMethod.GET)
    public String getCourseInfoByStuIdClassName(int StuId, String ClassName)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        List<StuCourse> stuCourses = stuICourseService.getCourseInfoByStuIdClassName(StuId,ClassName);
        try
        {
            map.put("status","200");
            map.put("courses", stuCourses);
        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/getCourseByClassName",method = RequestMethod.GET)
    public String getCourseByClassName(String ClassName)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        List<StuCourse> stuCourses = stuICourseService.getCourseByClassName(ClassName);
        try
        {
            map.put("status",200);
            map.put("courses",stuCourses);
        }
        catch(Exception ex)
        {
            map.put("status",400);
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/getAllCourse",method = RequestMethod.GET)
    public String getAllCourse()
    {
        Map<String,Object> map = new HashMap<String, Object>();
        List<StuCourse> stuCourses = stuICourseService.getAllCourse();
        try
        {

            map.put("status","200");
            map.put("courses", stuCourses);

        }
        catch (Exception ex)
        {
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }


}
