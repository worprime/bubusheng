package cn.com.chinahitech.bubusheng.student.service.impl;

import cn.com.chinahitech.bubusheng.student.entity.StuCourse;
import cn.com.chinahitech.bubusheng.student.entity.StuNotice;
import cn.com.chinahitech.bubusheng.student.entity.StuStudentclass;
import cn.com.chinahitech.bubusheng.student.mapper.StuNoticeMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StuStudentclassMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StuStudentgradeMapper;
import cn.com.chinahitech.bubusheng.student.service.StuICourseService;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentclassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
@Service
public class StuStudentclassServiceImpl extends ServiceImpl<StuStudentclassMapper, StuStudentclass> implements StuIStudentclassService {

    @Autowired
    private StuStudentclassMapper stuStudentclassMapper;

    @Autowired
    private StuStudentgradeMapper stuStudentgradeMapper;

    @Autowired
    private StuICourseService stuICourseService;

    @Autowired
    private StuIStudentclassService stuIStudentclassService;

    @Override
    public List<Integer> getClassIdByStuid(int StuId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("studentId",StuId);
        List<StuStudentclass> stuStudentclasses = stuStudentclassMapper.selectList(wrapper);
        List<Integer> integers = stuStudentclasses.stream().map(StuStudentclass::getClassId).collect(Collectors.toList());
        return integers;
    }

    public List<StuCourse> getCourseByClassList(List<Integer> classIds)
    {
        List<StuCourse> stuCourses = new ArrayList<StuCourse>();
        for(Integer classId : classIds)
        {
            StuCourse stuCourse = stuICourseService.getCourseByClassId(classId);
            stuCourses.add(stuCourse);
        }
        return stuCourses;
    }

    @Override
    public void studentJoinClass(int stuId, int classId) {
        StuStudentclass stuStudentclass = new StuStudentclass(stuId,classId);
        save(stuStudentclass);
    }
}
