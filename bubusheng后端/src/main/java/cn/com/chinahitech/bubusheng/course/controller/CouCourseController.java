package cn.com.chinahitech.bubusheng.course.controller;


import cn.com.chinahitech.bubusheng.course.service.ICouCourseService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
@RestController
@CrossOrigin
@RequestMapping("/course/course")
public class CouCourseController {

    @Autowired
    ICouCourseService courseService;

    @RequestMapping(value = "/course/updateCourse",method = RequestMethod.GET)
    public String updateCourse(Integer classId, String teacherName, String className, String intro, String beginning, String type){
        Map<String,Object> map = new HashMap<>();
        try{
            int result = courseService.updateCourse(classId,teacherName,className,intro,beginning,type);
            if(result == 1){
                map.put("status","200");
                map.put("msg","上传成功");
            }else{
                map.put("status","1");
                map.put("msg","上传失败");
            }
        }catch (Exception ex){
            map.put("status","500");
            map.put("msg","上传异常："+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

}
