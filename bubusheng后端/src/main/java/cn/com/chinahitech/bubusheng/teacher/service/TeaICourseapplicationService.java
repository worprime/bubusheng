package cn.com.chinahitech.bubusheng.teacher.service;

import cn.com.chinahitech.bubusheng.teacher.entity.Courseapplication;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
public interface TeaICourseapplicationService extends IService<Courseapplication> {
    int createCourse(String classname,String teachername,int teacherid,String intro,String beginning,String type);
}


