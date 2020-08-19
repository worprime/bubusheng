package cn.com.chinahitech.bubusheng.teacher.controller;


        import cn.com.chinahitech.bubusheng.teacher.service.TeaICourseapplicationService;
        import com.alibaba.fastjson.JSON;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.RequestMapping;

        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
@RestController
@RequestMapping("/create")
public class TeaCourseapplicationController {
        @Autowired
        private TeaICourseapplicationService icour;

        @RequestMapping(value = "/class",method = RequestMethod.GET)
        public String createCourse(String classname,String teachername,Integer teacherid,String intro,String beginning,String type){
            try {
                    icour.createCourse(classname,teachername,teacherid,intro,beginning,type);
                    return JSON.toJSONString("1");
            }catch (Exception e){
                    return JSON.toJSONString("0");
            }
        }
}
