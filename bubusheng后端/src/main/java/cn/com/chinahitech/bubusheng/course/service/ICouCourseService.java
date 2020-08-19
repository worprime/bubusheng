package cn.com.chinahitech.bubusheng.course.service;

import cn.com.chinahitech.bubusheng.course.entity.CouCourse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
public interface ICouCourseService extends IService<CouCourse> {
    Integer updateCourse(Integer classId,String teacherName,String className,String intro,String beginning, String type);


}
