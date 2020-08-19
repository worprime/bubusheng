package cn.com.chinahitech.bubusheng.teacher.service;

import cn.com.chinahitech.bubusheng.teacher.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
public interface TeaICourseService extends IService<Course> {
    List<Course> showCourse(int teacherid);
    Course findCourse(int courseid);
    List<Course> findCourselike(String classname,Integer teaid);
}