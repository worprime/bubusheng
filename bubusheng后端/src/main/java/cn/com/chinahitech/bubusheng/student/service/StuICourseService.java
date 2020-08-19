package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.StuCourse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-12
 */
public interface StuICourseService extends IService<StuCourse> {
    //根据课程号查询课程信息
    StuCourse getCourseByClassId(int ClassId);

    //根据学号和课程名查询课程信息
    List<StuCourse>  getCourseInfoByStuIdClassName(int StuId,String ClassName);

    //根据课程名模糊查询
    List<StuCourse> getCourseByClassName(String ClassName);

    //返回所有课程
    List<StuCourse> getAllCourse();


}
