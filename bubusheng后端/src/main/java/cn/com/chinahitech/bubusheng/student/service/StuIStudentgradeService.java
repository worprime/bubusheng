package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.CourseGrade;
import cn.com.chinahitech.bubusheng.student.entity.CourseTest;
import cn.com.chinahitech.bubusheng.student.entity.StuStudentgrade;
import cn.com.chinahitech.bubusheng.student.entity.StuTestpaper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
public interface StuIStudentgradeService extends IService<StuStudentgrade> {
    StuStudentgrade getStuStudentgradeByStuIdClassId(int Stuid,int Classid);

    List<CourseGrade> getCourseGradeByStuid(int Stuid);

    List<CourseTest> getCourseTestByStuid(int Stuid);

    List<CourseGrade> getCourseGradeByStuIdClassName(int StuId, String ClassName);

    boolean hasJoinClass(int StuId, int ClassId);

    public void studentJoinClass(int StuId, int ClassId);

}
