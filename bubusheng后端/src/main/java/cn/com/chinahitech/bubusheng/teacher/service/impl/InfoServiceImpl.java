package cn.com.chinahitech.bubusheng.teacher.service.impl;

import cn.com.chinahitech.bubusheng.teacher.entity.*;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaCourseMapper;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaStudentMapper;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaStudentgradeMapper;
import cn.com.chinahitech.bubusheng.teacher.service.InfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private TeaCourseMapper cour;

    @Autowired
    private TeaStudentMapper stu;

    @Autowired
    private TeaStudentgradeMapper gra;

    @Override
    public List<MyStudentinfo> statisticStuInfo(int teacherid) {
        QueryWrapper wrapper = new QueryWrapper();
        //查找老师对应课程
        wrapper.eq("teacherId",teacherid);
        List<Course> courses=cour.selectList(wrapper);

        List<MyStudentinfo> info=new ArrayList<MyStudentinfo>();
        for(int i =0;i<courses.size();i++){
            Course course=courses.get(i);
            Integer a =course.getClassId();
           String b =course.getClassName();
            //查找课程对应学生,成绩表
            QueryWrapper wrapper1=new QueryWrapper();
            wrapper1.eq("classId",a);
            List<Studentgrade> grade =gra.selectList(wrapper1);
            //加载学生信息
            if(grade.size()>0){
                for (int j = 0; j < grade.size(); j++) {
                    Studentgrade studentgrade = grade.get(j);
                    MyStudentinfo x=new MyStudentinfo();
                    x.setClassId(a);
                    x.setClassName(b);
                    x.setScore(studentgrade.getScore());
                    x.setStudentId(studentgrade.getStudentId());
                    QueryWrapper wrapper2 = new QueryWrapper();
                    wrapper2.eq("studentId", studentgrade.getStudentId());
                    Student student = stu.selectOne(wrapper2);
                    x.setAge(student.getAge());
                    x.setPhone(student.getPhone());
                    x.setSex(student.getSex());
                    x.setStudentName(student.getStudentName());
                    info.add(x);
                }
            }
        }
        return info;
    }

    @Override
    public List<MyStudentinfo> findStuInfoByClassid(int classid, int teacherid) {
        QueryWrapper wrapper = new QueryWrapper();
        //筛选看老师是否教导此课程
        wrapper.eq("teacherId",teacherid);
        wrapper.eq("classId",classid);
        Course courses=cour.selectOne(wrapper);
        List<MyStudentinfo> info=new ArrayList<MyStudentinfo>();
        if(courses!=null){
            Integer cla=courses.getClassId();
            String claname=courses.getClassName();
            QueryWrapper wrapper1 = new QueryWrapper();
            //查找老师对应课程
            wrapper1.eq("classId",classid);
            List<Studentgrade> grade=gra.selectList(wrapper1);
            if (grade.size()>0){
                for(int j = 0; j < grade.size(); j++){
                    Studentgrade studentgrade = grade.get(j);
                    MyStudentinfo x=new MyStudentinfo();
                    x.setClassId(cla);
                    x.setClassName(claname);
                    x.setScore(studentgrade.getScore());
                    x.setStudentId(studentgrade.getStudentId());

                    QueryWrapper wrapper2 = new QueryWrapper();
                    wrapper2.eq("studentId", x.getStudentId());
                    Student student = stu.selectOne(wrapper2);
                    x.setAge(student.getAge());
                    x.setPhone(student.getPhone());
                    x.setStudentName(student.getStudentName());
                    x.setSex(student.getSex());
                    info.add(x);
                }
                return info;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public List<MyStudentinfo> findStuInfoByName(String stuname, int teacherid) {
        QueryWrapper wrapper = new QueryWrapper();
        //查找老师对应课程
        wrapper.eq("teacherId",teacherid);
        List<Course> courses=cour.selectList(wrapper);
        List<MyStudentinfo> info=new ArrayList<MyStudentinfo>();
        for(int i =0;i<courses.size();i++){
            Course course=courses.get(i);
            Integer a =course.getClassId();
            String b =course.getClassName();
            //查找课程对应学生,成绩表
            QueryWrapper wrapper1=new QueryWrapper();
            wrapper1.eq("classId",a);
            List<Studentgrade> grade =gra.selectList(wrapper1);
            //加载学生信息
            if(grade.size()>0){
                for (int j = 0; j < grade.size(); j++) {
                    Studentgrade studentgrade = grade.get(j);
                    MyStudentinfo x=new MyStudentinfo();
                    x.setClassId(a);
                    x.setClassName(b);
                    x.setScore(studentgrade.getScore());
                    x.setStudentId(studentgrade.getStudentId());
                    QueryWrapper wrapper2 = new QueryWrapper();
                    wrapper2.like("studentName",stuname);
                    wrapper2.eq("studentId", studentgrade.getStudentId());
                    Student student = stu.selectOne(wrapper2);
                    if(student==null){
                        continue;
                    }
                    x.setAge(student.getAge());
                    x.setPhone(student.getPhone());
                    x.setSex(student.getSex());
                    x.setStudentName(student.getStudentName());
                    info.add(x);


                }
            }
        }
        return info;
    }
}
