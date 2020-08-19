package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.StuCourse;
import cn.com.chinahitech.bubusheng.student.entity.StuStudentclass;
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
public interface StuIStudentclassService extends IService<StuStudentclass> {
    List<Integer> getClassIdByStuid(int StuId);

    List<StuCourse> getCourseByClassList(List<Integer> classIds);

    public void studentJoinClass(int stuId, int classId);
}
