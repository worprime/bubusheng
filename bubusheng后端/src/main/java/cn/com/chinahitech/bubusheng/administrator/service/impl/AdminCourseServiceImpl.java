package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourse;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminCourseMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
@Service
public class AdminCourseServiceImpl extends ServiceImpl<AdminCourseMapper, AdminCourse> implements IAdminCourseService {

    @Autowired
    private AdminCourseMapper adminCourseMapper;

    @Override
    public IPage<AdminCourse> getAllCourse(int currentPage, int limit) {
        IPage<AdminCourse> CoursePage = new Page<>(currentPage,limit);
        CoursePage = adminCourseMapper.selectPage(CoursePage,null);
        return CoursePage;
    }

    @Override
    public AdminCourse getCourseById(String id) {
        QueryWrapper<AdminCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("classId",id);
        AdminCourse adminCourse = adminCourseMapper.selectOne(wrapper);
        return adminCourse;
    }

    @Override
    public IPage<AdminCourse> getCourseByKey(int currentPage, int limit, String key, String keyword) {
        IPage<AdminCourse> coursePage = new Page<>(currentPage,limit);
        QueryWrapper<AdminCourse> wrapper = new QueryWrapper<>();
        wrapper.like(key,keyword);
        coursePage = adminCourseMapper.selectPage(coursePage,wrapper);
        return coursePage;
    }

    @Override
    public IPage<AdminCourse> getCourseByTeacherId(int currentPage, int limit, String id) {
        IPage<AdminCourse> coursePage = new Page<>(currentPage,limit);
        QueryWrapper<AdminCourse> wrapper = new QueryWrapper<>();
        wrapper.like("teacherId",id);
        coursePage = adminCourseMapper.selectPage(coursePage,wrapper);
        return coursePage;
    }
}
