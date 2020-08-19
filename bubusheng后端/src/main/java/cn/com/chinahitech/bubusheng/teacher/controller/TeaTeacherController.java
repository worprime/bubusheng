package cn.com.chinahitech.bubusheng.teacher.controller;


import cn.com.chinahitech.bubusheng.teacher.entity.Teacher;
import cn.com.chinahitech.bubusheng.teacher.service.TeaITeacherService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
 * @author zhufu
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/teacher")
public class TeaTeacherController {
    @Autowired
    private TeaITeacherService tea;

    @RequestMapping(value = "/login/{id}",method = RequestMethod.GET)
    public String login(@PathVariable("id") int id){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Teacher teacher=tea.getAccount(id);
            map.put("status",200);
            map.put("data",teacher);
        }catch (Exception ex){
            map.put("status",500);
            map.put("errorMsg","err");
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public Integer signup(Integer teaid,String name,String phone,String password){
       try {
           tea.signup(teaid,name,phone,password);
           return 1;
       }catch (Exception e){
           return 0;
       }

    }
}
