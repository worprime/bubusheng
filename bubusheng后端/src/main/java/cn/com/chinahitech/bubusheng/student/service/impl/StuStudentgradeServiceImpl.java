package cn.com.chinahitech.bubusheng.student.service.impl;

import cn.com.chinahitech.bubusheng.student.entity.*;
import cn.com.chinahitech.bubusheng.student.mapper.StuCourseMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StuStudentgradeMapper;
import cn.com.chinahitech.bubusheng.student.service.StuICourseService;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentclassService;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentgradeService;
import cn.com.chinahitech.bubusheng.student.service.StuITestpaperService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
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
public class StuStudentgradeServiceImpl extends ServiceImpl<StuStudentgradeMapper, StuStudentgrade> implements StuIStudentgradeService {

    @Autowired
    private StuIStudentclassService stuIStudentclassService;

    @Autowired
    private StuIStudentgradeService stuIStudentgradeService;

    @Autowired
    private StuICourseService stuICourseService;

    @Autowired
    private StuITestpaperService stuITestpaperService;


    @Autowired
    private StuCourseMapper stuCourseMapper;

    @Autowired
    private StuStudentgradeMapper stuStudentgradeMapper;

    @Override
    public StuStudentgrade getStuStudentgradeByStuIdClassId(int Stuid, int Classid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("studentId",Stuid);
        wrapper.eq("classId",Classid);
        StuStudentgrade stuStudentgrade = stuStudentgradeMapper.selectOne(wrapper);
        return stuStudentgrade;
    }

    @Override
    public List<CourseGrade> getCourseGradeByStuid(int Stuid) {
        List<Integer> classIds = stuIStudentclassService.getClassIdByStuid(Stuid);

        List<CourseGrade> courseGrades = new ArrayList<CourseGrade>();

        for(int j=0;j<classIds.size();j++)
        {
            StuCourse stuCourse = stuICourseService.getCourseByClassId(classIds.get(j));

            StuStudentgrade stuStudentgrade = stuIStudentgradeService.getStuStudentgradeByStuIdClassId(Stuid,classIds.get(j));

            CourseGrade courseGrade = new CourseGrade();

            if(stuStudentgrade.getscore()!=0)//分数为空
            {
                courseGrade.setGrades(stuStudentgrade.getscore());
                courseGrade.setClassName(stuCourse.getClassName());
                courseGrade.setCourseId(stuCourse.getClassId());
                courseGrade.setTeacher(stuCourse.getTeacherName());
                courseGrades.add(courseGrade);
            }
        }
        return courseGrades;
    }

    @Override
    public List<CourseTest> getCourseTestByStuid(int Stuid) {
        List<Integer> classIds = stuIStudentclassService.getClassIdByStuid(Stuid);

        List<CourseTest> courseTests = new ArrayList<CourseTest>();

        for(int j=0;j<classIds.size();j++)
        {
            CourseTest courseTest = new CourseTest();
            StuCourse stuCourse = stuICourseService.getCourseByClassId(classIds.get(j));
            courseTest.setCourseName(stuCourse.getClassName());
            courseTest.setTeacher(stuCourse.getTeacherName());

            StuTestpaper stuTestpaper = stuITestpaperService.getStuTestpaperByClassId(classIds.get(j));

            if(stuTestpaper==null)
            {
                courseTest.setDdl("");
                courseTest.setTestOpen("否");
            }
            else
            {
                courseTest.setDdl(stuTestpaper.getDeadline());
                courseTest.setTestOpen("是");
            }
            courseTests.add(courseTest);
        }
        return courseTests;
    }

    @Override
    public List<CourseGrade> getCourseGradeByStuIdClassName(int StuId, String ClassName) {

        List<CourseGrade> courseGrades = stuIStudentgradeService.getCourseGradeByStuid(StuId);
        List<CourseGrade> courseGrades2 = new ArrayList<CourseGrade>();

        for(int i = 0 ; i < courseGrades.size(); i++)
        {
            if(courseGrades.get(i).getClassName().equals(ClassName))
            {
                CourseGrade courseGrade = courseGrades.get(i);
                courseGrades2.add(courseGrade);
            }
        }
        return courseGrades2;
    }

    @Override
    public boolean hasJoinClass(int StuId, int ClassId) {
        boolean hasJoin = false;
        List<Integer> integers = stuIStudentclassService.getClassIdByStuid(StuId);
        if(integers==null)
        {
            return false;
        }
        else
        {
            for(int i=0;i<integers.size();i++)
            {
                if(integers.get(i)==ClassId)
                {
                    hasJoin = true;
                }
            }
        }
        return hasJoin;
    }

    @Override
    public void studentJoinClass(int StuId, int ClassId) {
        StuStudentgrade stuStudentgrade = new StuStudentgrade();
        stuStudentgrade.setStudentId(StuId);
        stuStudentgrade.setClassId(ClassId);
        stuStudentgrade.setScore(0);
        save(stuStudentgrade);
    }


}
