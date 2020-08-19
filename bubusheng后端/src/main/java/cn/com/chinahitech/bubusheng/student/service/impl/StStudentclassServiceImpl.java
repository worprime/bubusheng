package cn.com.chinahitech.bubusheng.student.service.impl;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminCourseMapper;
import cn.com.chinahitech.bubusheng.student.entity.StStudent;
import cn.com.chinahitech.bubusheng.student.entity.StStudentclass;
import cn.com.chinahitech.bubusheng.student.entity.StStudentgrade;
import cn.com.chinahitech.bubusheng.student.mapper.StStudentMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StStudentclassMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StStudentgradeMapper;
import cn.com.chinahitech.bubusheng.student.service.StIStudentclassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
@Service
public class StStudentclassServiceImpl extends ServiceImpl<StStudentclassMapper, StStudentclass> implements StIStudentclassService {

    @Autowired
    private StStudentgradeMapper studentgradeMapper;
    @Autowired
    private AdminCourseMapper adminCourseMapper;
    @Autowired
    private StStudentMapper studentMapper;

    //1.为学生新增课程
    @Override
    public boolean insertStudentClass(int  stuId, int classId) {
        StStudentgrade studentgrade=studentgradeMapper.selectOne(new QueryWrapper<StStudentgrade>()
                                                                            .eq("studentId",stuId)
                                                                            .eq("classId",classId));

        if(studentgrade==null){
            try {
                Connection connection = null;
                Statement statement = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://39.98.127.39:3306/bubusheng?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                        "bubusheng_root", "Root_root");
                statement = (Statement) connection.createStatement();
                String sql = "INSERT INTO studentgrade VALUES(" + stuId + "," + classId +",0,0,0,0)";
                statement.executeUpdate(sql);
                return true;
            }catch(Exception e){
                return false;
            }
        }
        return false;
    }

    //2.删除学生的选课
    @Override
    public boolean deleteStudentClass(int stuId, int classId) {
        StStudentgrade studentgrade=studentgradeMapper.selectOne(new QueryWrapper<StStudentgrade>()
                .eq("studentId",stuId)
                .eq("classId",classId));
        int success;
        if(studentgrade!=null){
            try {
                Connection connection = null;
                Statement statement = null;
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://39.98.127.39:3306/bubusheng?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                        "bubusheng_root", "Root_root");
                statement = (Statement) connection.createStatement();
                String sql = "delete from studentgrade where studentId= " + stuId + " and classId= " + classId;
                success = statement.executeUpdate(sql);
                return true;
            }catch(Exception e){
                return false;
            }
        }
        return false;
    }

    //4.根据课程id查询所有学生
    @Override
    public List<StStudent> getClassStudent(int classId) {
        List<StStudentgrade> temp=studentgradeMapper.selectList(new QueryWrapper<StStudentgrade>()
                .eq("classId",classId));
        ListIterator<StStudentgrade> a=temp.listIterator();
        List<StStudent> result=new ArrayList<StStudent>();
        while(a.hasNext()){
            int studentId=a.next().getStudentId();
            QueryWrapper<StStudent> wrapper=new QueryWrapper<>();
            wrapper.eq("studentId",studentId);
            StStudent aStudent=studentMapper.selectOne(wrapper);
            result.add(aStudent);
        }
        return result;
    }
}
