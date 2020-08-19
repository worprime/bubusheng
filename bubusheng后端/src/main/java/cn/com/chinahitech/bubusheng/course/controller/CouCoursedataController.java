package cn.com.chinahitech.bubusheng.course.controller;


import cn.com.chinahitech.bubusheng.course.entity.CouCoursedata;
import cn.com.chinahitech.bubusheng.course.service.ICouCoursedataService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hourui
 * @since 2020-08-12
 */
@RestController
@CrossOrigin
@RequestMapping("/course/coursedata")
public class CouCoursedataController {

    @Autowired
    ICouCoursedataService courseDataService;

    @RequestMapping(value = "/course/uploadData",method = RequestMethod.POST)
    public String uploadData(Integer classId, Integer chapter, MultipartFile ppt, MultipartFile document){
        Map<String,Object> map = new HashMap<>();
        try{
            int result = courseDataService.insertCourseData(classId,chapter,ppt,document);
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

    @RequestMapping(value = "/course/insertExercise",method = RequestMethod.POST)
    public String insertExerciseAndAnswer(Integer classId , Integer chapter , String exercise,String answer){
        Map<String,Object> map = new HashMap<>();
        try{
            int result = courseDataService.insertExerciseAndAnswer(classId,chapter,exercise,answer);
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

    @RequestMapping(value = "/course/uploadVideo",method = RequestMethod.POST)
    public String uploadVideo(Integer classId , Integer chapter , MultipartFile video){
        Map<String,Object> map = new HashMap<>();
        try{
            int result = courseDataService.insertVideo(classId,chapter,video);
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

//    @RequestMapping(value = "/course/getCourseDataListByClassId",method = RequestMethod.POST)
//    public String getCourseDataListByClassId(int classId){
//        Map<String,Object> map = new HashMap<>();
//        try{
//                List<CouCoursedata> coursedataList = courseDataService.getCourseDataListByClassId(classId);
//                if(coursedataList != null){
//                    map.put("status","200");
//                    map.put("data",coursedataList);
//                }else{
//                    map.put("status","404");
//                    map.put("errorMsg","not found");
//                }
//
//        }catch (Exception ex){
//            map.put("status","500");
//            map.put("msg","检索出错："+ex.getMessage());
//        }
//        return JSON.toJSONString(map);
//    }
//
//    @RequestMapping(value = "/course/getCourseDataListByClassId",method = RequestMethod.POST)
//    public String getCourseDataByIdAndChapter(int classId ,int chapter){
//        Map<String,Object> map = new HashMap<>();
//        try{
//            CouCoursedata coursedata = courseDataService.getCourseDataByIdAndChapter(classId ,chapter);
//            if(coursedata != null){
//                map.put("status","200");
//                map.put("data",coursedata);
//            }else{
//                map.put("status","404");
//                map.put("errorMsg","not found");
//            }
//
//        }catch (Exception ex){
//            map.put("status","500");
//            map.put("msg","检索出错："+ex.getMessage());
//        }
//        return JSON.toJSONString(map);
//    }

}
