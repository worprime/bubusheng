package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminTeacher;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminTeacherMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
 * @since 2020-08-12
 */
@Service
public class AdminTeacherServiceImpl extends ServiceImpl<AdminTeacherMapper, AdminTeacher> implements IAdminTeacherService {

    @Autowired
    private AdminTeacherMapper adminTeacherMapper;

    @Override
    public IPage<AdminTeacher> getAllTeacher(int currentPage, int limit) {
        IPage<AdminTeacher> teacherPage = new Page<>(currentPage,limit);
        QueryWrapper<AdminTeacher> wrapper = new QueryWrapper<>();
        wrapper.select("teacherId","teacherName","phone");
        teacherPage = adminTeacherMapper.selectPage(teacherPage,wrapper);
        return teacherPage;
    }

    @Override
    public AdminTeacher getTeacherById(String id) {
        QueryWrapper<AdminTeacher> wrapper = new QueryWrapper<>();
        wrapper.eq("teacherId",id);
        AdminTeacher adminTeacher = adminTeacherMapper.selectOne(wrapper);
        return adminTeacher;
    }

    @Override
    public IPage<AdminTeacher> getTeacherByKey(int currentPage, int limit, String key, String keyword) {
        IPage<AdminTeacher> teacherPage = new Page<>(currentPage,limit);
        QueryWrapper<AdminTeacher> wrapper = new QueryWrapper<>();
        wrapper.eq(key,keyword);
        teacherPage = adminTeacherMapper.selectPage(teacherPage,wrapper);
        return teacherPage;
    }

    @Override
    public void deleteTeacher(String id) {
        UpdateWrapper<AdminTeacher> wrapper = new UpdateWrapper<>();
        wrapper.eq("teacherId",id);
        adminTeacherMapper.delete(wrapper);
    }


}
