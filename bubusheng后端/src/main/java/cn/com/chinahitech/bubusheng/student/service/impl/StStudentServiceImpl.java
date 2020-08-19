package cn.com.chinahitech.bubusheng.student.service.impl;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminCourseMapper;
import cn.com.chinahitech.bubusheng.student.entity.StCourseData;
import cn.com.chinahitech.bubusheng.student.entity.StStudent;
import cn.com.chinahitech.bubusheng.student.mapper.StCourseDataMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StStudentMapper;
import cn.com.chinahitech.bubusheng.student.service.StIStudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
@Service
public class StStudentServiceImpl extends ServiceImpl<StStudentMapper, StStudent> implements StIStudentService {

    @Autowired
    private StStudentMapper studentMapper;
    @Autowired
    private StCourseDataMapper courseDataMapper;

    //1.新增学生
    @Override
    public boolean insertStudent(String stuName,String sex,Integer age,String password,String phone){
        StStudent student=studentMapper.selectOne(new QueryWrapper<StStudent>()
                .eq("phone",phone));
        if(student==null){
            StStudent createdStudent=new StStudent();
            createdStudent.setAge(age);
            createdStudent.setPassword(password);
            createdStudent.setPhone(phone);
            createdStudent.setStudentName(stuName);
            createdStudent.setSex(sex);
            createdStudent.setFlag(0);
            save(createdStudent);
            return true;
        }
        return false;
    }

    //2.更新学生个人信息
    @Override
    public boolean updateStudent(Integer stuId,String stuName,String sex,Integer age,String password,String phone) {
        QueryWrapper<StStudent> wrapper=new QueryWrapper<>();
        wrapper.eq("studentId",stuId);
        StStudent student=studentMapper.selectOne(wrapper);
        student.setStudentName(stuName);
        student.setSex(sex);
        student.setAge(age);
        student.setPassword(password);
        student.setPhone(phone);
        boolean i=update(student,wrapper);
        return i;
    }

    //3.根据课程id查找视频地址
    public String findPathByClassId(Integer classId){
        QueryWrapper<StCourseData> wrapper=new QueryWrapper<>();
        wrapper.eq("classid",classId);
        StCourseData coursedata=courseDataMapper.selectOne(wrapper);
        return coursedata.getVideo();
    };

    //4.利用手机号查找学生ID
    @Override
    public  int	getStudentId(String phone) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("phone",phone);
        StStudent student=studentMapper.selectOne(wrapper);
        return student.getStudentId();
    }
    //5.获取所有学生的信息
    @Override
    public StStudent getAllStudent(int id) {
        return studentMapper.selectById(id);
    }

    //6.模糊查询学生列表
    @Override
    public List<StStudent> getStudentKey(String keyword) {
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.like("studentName",keyword);
        List<StStudent> studentList=studentMapper.selectList(wrapper);
        return studentList;
    }

    //7.恢复为活动状态(查不出来的)
    @Override
    public int revertStudent(int uid)  {
        int i=0;
        try {
            Connection connection = null;
            Statement statement = null;
            Class.forName("com.mysql..cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://39.98.127.39:3306/bubusheng?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                    "bubusheng_root", "Root_root");
            statement = (Statement) connection.createStatement();
            String sql = "UPDATE student SET flag=0 WHERE studentId=" + uid;
            i = statement.executeUpdate(sql);
        }catch(Exception e){
            return -1;
        }
        return i;
    }

    //8.登录
    @Override
    public boolean loginByAccoutAndPassword(String phone, String password) {
        QueryWrapper<StStudent> wrapper=new QueryWrapper<>();
        wrapper.eq("phone",phone)
               .eq("password",password);
        StStudent student=studentMapper.selectOne(wrapper);
        if(student == null)
            return false;
        return true;
    }

    //9.根据学生登录名来查找学生
    @Override
    public List<StStudent> findStudentByAccount(String account){
        QueryWrapper<StStudent> wrapper=new QueryWrapper<>();
        wrapper.eq("studentName",account);
        List<StStudent> student=studentMapper.selectList(wrapper);
        return student;
    }
}
