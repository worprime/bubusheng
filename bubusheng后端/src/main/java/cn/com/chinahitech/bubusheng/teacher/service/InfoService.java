package cn.com.chinahitech.bubusheng.teacher.service;

import cn.com.chinahitech.bubusheng.teacher.entity.Course;
import cn.com.chinahitech.bubusheng.teacher.entity.MyStudentinfo;
import cn.com.chinahitech.bubusheng.teacher.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InfoService {
    List<MyStudentinfo> statisticStuInfo(int teacherid);
    List<MyStudentinfo> findStuInfoByClassid(int classid,int teacherid);
    List<MyStudentinfo> findStuInfoByName(String stuname,int teacherid);
}
