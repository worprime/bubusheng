package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.StStudent;
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
public interface StIStudentService extends IService<StStudent> {
    //1.新增学生
    public boolean insertStudent(String stuName,String sex,Integer age,String password,String phone);
    //2.更新学生信息
    public boolean updateStudent(Integer stuId,String stuName,String sex,Integer age,String password,String phone);
    //3.根据课程id查找视频地址
    public String findPathByClassId(Integer classId);
    //4.根据学生手机号查询ID
    public int	getStudentId(String phone);
    //5.获取学生的所有信息
    public StStudent getAllStudent(int id);
    //6.模糊查询学生列表
    public List<StStudent> getStudentKey(String keyword);
    //7.恢复为活动状态
    public int revertStudent(int uid) ;
    //8.登录
    public boolean loginByAccoutAndPassword(String phone,String password );
    //9.根据学生登录名来查找学生
    public List<StStudent> findStudentByAccount(String account);
}
