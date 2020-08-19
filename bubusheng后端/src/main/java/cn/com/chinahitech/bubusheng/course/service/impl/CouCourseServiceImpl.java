package cn.com.chinahitech.bubusheng.course.service.impl;

import cn.com.chinahitech.bubusheng.course.service.ICouCourseService;
import cn.com.chinahitech.bubusheng.course.entity.CouCourse;
import cn.com.chinahitech.bubusheng.course.mapper.CouCourseMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
@Service
public class CouCourseServiceImpl extends ServiceImpl<CouCourseMapper, CouCourse> implements ICouCourseService {
    @Autowired
    private CouCourseMapper courseMapper;


    @Override
    public Integer updateCourse(Integer classId, String teacherName, String className, String intro, String beginning, String type) {
        UpdateWrapper<CouCourse> wrapper = new UpdateWrapper<>();
        wrapper.eq("classId",classId);
        CouCourse course = new CouCourse();
        course.setClassName(className);
        course.setTeacherName(teacherName);
        course.setBeginning(beginning);
        course.setIntro(intro);
        course.setType(type);
        int i = courseMapper.update(course,wrapper);
        return i;
    }
}
