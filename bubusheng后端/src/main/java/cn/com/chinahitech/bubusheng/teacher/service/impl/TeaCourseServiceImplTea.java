package cn.com.chinahitech.bubusheng.teacher.service.impl;

import cn.com.chinahitech.bubusheng.teacher.entity.Course;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaCourseMapper;
import cn.com.chinahitech.bubusheng.teacher.service.TeaICourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
@Service
public class TeaCourseServiceImplTea extends ServiceImpl<TeaCourseMapper, Course> implements TeaICourseService {
    @Autowired
   private TeaCourseMapper cour;

    @Override
    public List<Course> showCourse(int teacherid) {
        QueryWrapper wrapper = new QueryWrapper();
        //wrapper.like(列名，值)
        wrapper.eq("teacherId",teacherid);
        List<Course> coursesinfo=cour.selectList(wrapper);
        return coursesinfo;
    }

    @Override
    public Course findCourse(int courseid) {
        QueryWrapper wrapper = new QueryWrapper();
        //wrapper.like(列名，值)
        wrapper.eq("classId",courseid);
        Course coursesinfo=cour.selectOne(wrapper);
        return coursesinfo;
    }

    @Override
    public List<Course> findCourselike(String classname,Integer teaid) {
        QueryWrapper wrapper = new QueryWrapper();
        //wrapper.like(列名，值)
        wrapper.like("className",classname);
        wrapper.eq("teacherId",teaid);
        List<Course> coursesinfo=cour.selectList(wrapper);
        return coursesinfo;
    }

}
