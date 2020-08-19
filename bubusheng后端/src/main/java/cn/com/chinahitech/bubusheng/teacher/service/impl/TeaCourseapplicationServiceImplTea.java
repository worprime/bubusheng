package cn.com.chinahitech.bubusheng.teacher.service.impl;

import cn.com.chinahitech.bubusheng.teacher.entity.Courseapplication;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaCourseapplicationMapper;
import cn.com.chinahitech.bubusheng.teacher.service.TeaICourseapplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
@Service
public class TeaCourseapplicationServiceImplTea extends ServiceImpl<TeaCourseapplicationMapper, Courseapplication> implements TeaICourseapplicationService {
    @Autowired
    private TeaCourseapplicationMapper courapp;


    @Override
    public int createCourse(String classname, String teachername, int teacherid, String intro, String beginning, String type) {
        Courseapplication x = new Courseapplication(classname,teacherid,teachername,intro,type,beginning);
        save(x);
        return 0;
    }
}
