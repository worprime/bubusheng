package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.StStudentgrade;
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
public interface StIStudentgradeService extends IService<StStudentgrade> {
    //1.新增学生分数
    public boolean insertStudentGrade(int stuId,int classId,int score);
    //2.更改学生分数
    public boolean updateStudentGrade(int stuId,int classId,int score);
    //3.根据id和课程查询分数
    public int findStudentGradeById(String classId,String studentId);
    //4.根据课程id查找分数
    public List<StStudentgrade> findStudentGradeByClassId(int classId);
    //5.根据学生id查找分数
    public List<StStudentgrade> getStudentGrade(int stuId);

}
