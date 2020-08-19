package cn.com.chinahitech.bubusheng.student.service;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourse;
import cn.com.chinahitech.bubusheng.student.entity.StStudent;
import cn.com.chinahitech.bubusheng.student.entity.StStudentclass;
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
public interface StIStudentclassService extends IService<StStudentclass> {
    //1.新增学生选课
    public boolean insertStudentClass(int stuId,int classId);
    //2.删除学生选课
    public boolean deleteStudentClass(int stuId,int classId);

    //4.根据课程id查询所有学生
    public List<StStudent> getClassStudent(int classId);
}
