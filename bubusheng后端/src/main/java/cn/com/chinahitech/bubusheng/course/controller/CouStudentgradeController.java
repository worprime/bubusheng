package cn.com.chinahitech.bubusheng.course.controller;


import cn.com.chinahitech.bubusheng.course.entity.CouStudentgrade;
import cn.com.chinahitech.bubusheng.course.service.ICouStudentgradeService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
 * @since 2020-08-15
 */
@RestController
@CrossOrigin
@RequestMapping("/course/studentgrade")
public class CouStudentgradeController {

    @Autowired
    ICouStudentgradeService studentgradeService;


    @RequestMapping(value = "/course/setStudentGrade",method = RequestMethod.GET)
    public String setStudentGrade(Integer studentId,Integer classId,Integer score,String annotation,String answer){
        Map<String,Object> map = new HashMap<>();
        try{
            int result = studentgradeService.setStudentGrade(studentId,classId,score,annotation,answer);
            if(result == 1){
                map.put("status","200");
                map.put("msg","批改成功");
            }else{
                map.put("status","1");
                map.put("msg","批改失败");
            }
        }catch (Exception ex){
            map.put("status","500");
            map.put("msg","批改异常："+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/course/getStudentGrade",method = RequestMethod.GET)
    public String getStudentGrade(int classId ,int currentPage ,int limit){
        Map<String,Object> map = new HashMap<>();
        try{
            IPage<CouStudentgrade> studentgradeIPage = studentgradeService.getStudentGrade(classId,currentPage,limit);
            if(studentgradeIPage != null){
                map.put("status","200");
                map.put("data",studentgradeIPage.getRecords());
                map.put("total",studentgradeIPage.getTotal());
            }else{
                map.put("status","404");
                map.put("errorMsg","not found");
            }

        }catch (Exception ex){
            map.put("status","500");
            map.put("msg","检索出错："+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}



