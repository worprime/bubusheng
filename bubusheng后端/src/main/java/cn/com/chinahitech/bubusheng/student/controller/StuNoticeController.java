package cn.com.chinahitech.bubusheng.student.controller;


import cn.com.chinahitech.bubusheng.student.entity.StuNotice;
import cn.com.chinahitech.bubusheng.student.service.StuINoticeService;
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
 * @author zhouzihao
 * @since 2020-08-12
 */
@RestController
@CrossOrigin
@RequestMapping("/student/notice")
public class StuNoticeController {


    @Autowired
    private StuINoticeService noticeService;

    @RequestMapping(value = "/getNoticeByClassId",method = RequestMethod.GET)
    public String getNoticeByClassId(int ClassId)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<StuNotice> stuNoticeList = noticeService.getNoticeByClassId(ClassId);
            int num = stuNoticeList.size();
            map.put("status","200");
            map.put("noticedata", stuNoticeList);
            map.put("num",num);
        }
        catch (Exception ex){
            map.put("status","400");
            map.put("errorMsg","检索出错"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

}
