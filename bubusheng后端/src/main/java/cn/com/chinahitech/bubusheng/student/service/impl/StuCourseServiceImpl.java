package cn.com.chinahitech.bubusheng.student.service.impl;

import cn.com.chinahitech.bubusheng.student.entity.StuCourse;
import cn.com.chinahitech.bubusheng.student.entity.StuNotice;
import cn.com.chinahitech.bubusheng.student.mapper.StuCourseMapper;
import cn.com.chinahitech.bubusheng.student.mapper.StuNoticeMapper;
import cn.com.chinahitech.bubusheng.student.service.StuICourseService;
import cn.com.chinahitech.bubusheng.student.service.StuIStudentclassService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-12
 */
@Service
public class StuCourseServiceImpl extends ServiceImpl<StuCourseMapper, StuCourse> implements StuICourseService {
    @Autowired
    private StuCourseMapper stuCourseMapper;

    @Autowired
    private StuIStudentclassService stuIStudentclassService;

    @Override
    public StuCourse getCourseByClassId(int ClassId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("classId",ClassId);
        StuCourse stuCourse = stuCourseMapper.selectOne(wrapper);
        return stuCourse;
    }

    @Override
    public List<StuCourse> getCourseInfoByStuIdClassName(int StuId, String ClassName) {

        List<Integer> integers = stuIStudentclassService.getClassIdByStuid(StuId);
        List<StuCourse> stuCourses = stuIStudentclassService.getCourseByClassList(integers);
        List<StuCourse> stuCourses2 = new ArrayList<StuCourse>();
        for(int i=0;i<stuCourses.size();i++)
        {
            if(stuCourses.get(i).getClassName().equals(ClassName))
            {
                stuCourses2.add(stuCourses.get(i));
            }
        }
        return stuCourses2;
    }


    @Override
    public List<StuCourse> getCourseByClassName(String ClassName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("className",ClassName);
        List<StuCourse> stuCourses = stuCourseMapper.selectList(wrapper);
        return stuCourses;
    }

    @Override
    public List<StuCourse> getAllCourse() {
        QueryWrapper wrapper = new QueryWrapper();
        List<StuCourse> stuCourses = stuCourseMapper.selectList(wrapper);
        return stuCourses;
    }
}
