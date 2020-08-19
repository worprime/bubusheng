package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourse;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourseApplication;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminCourseApplicationMapper;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminCourseMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminCourseApplicationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
@Service
public class AdminCourseApplicationServiceImpl extends ServiceImpl<AdminCourseApplicationMapper, AdminCourseApplication> implements IAdminCourseApplicationService {

    @Autowired
    private AdminCourseApplicationMapper adminCourseApplicationMapper;
    @Autowired
    private AdminCourseMapper adminCourseMapper;

    @Override
    public IPage<AdminCourseApplication> getAllAduit(int currentPage, int limit) {
        IPage<AdminCourseApplication> applicationPage = new Page<>(currentPage, limit);
        applicationPage = adminCourseApplicationMapper.selectPage(applicationPage, null);
        return applicationPage;
    }

    @Override
    public AdminCourseApplication getAduitById(String id) {
        QueryWrapper<AdminCourseApplication> wrapper = new QueryWrapper<>();
        wrapper.eq("Id", id);
        AdminCourseApplication adminCourseApplication = adminCourseApplicationMapper.selectOne(wrapper);
        return adminCourseApplication;
    }

    @Override
    public IPage<AdminCourseApplication> getAduitByKey(int currentPage, int limit, String key, String keyword) {
        IPage<AdminCourseApplication> applicationPage = new Page<>(currentPage, limit);
        QueryWrapper<AdminCourseApplication> wrapper = new QueryWrapper<>();
        wrapper.like(key, keyword);
        applicationPage = adminCourseApplicationMapper.selectPage(applicationPage, wrapper);
        return applicationPage;
    }

    @Override
    public void sumbitAduit(String id) {
        try {
            AdminCourseApplication adminCourseApplication = getAduitById(id);
            AdminCourse adminCourse = new AdminCourse();
            adminCourse.setTeacherId(adminCourseApplication.getTeacherId());
            adminCourse.setTeacherName(adminCourseApplication.getTeacherName());
            adminCourse.setBeginning(adminCourseApplication.getBeginning());
            adminCourse.setClassName(adminCourseApplication.getClassName());
            adminCourse.setIntro(adminCourseApplication.getIntro());
            adminCourse.setType(adminCourseApplication.getType());
            adminCourseMapper.insert(adminCourse);
            UpdateWrapper<AdminCourseApplication> wrapper = new UpdateWrapper<>();
            wrapper.eq("Id", id);
            adminCourseApplication.setResult("已通過");
            adminCourseApplicationMapper.update(adminCourseApplication, wrapper);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void unsumbitAduit(String id) {
        AdminCourseApplication adminCourseApplication = getAduitById(id);
        UpdateWrapper<AdminCourseApplication> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id);
        adminCourseApplication.setResult("未通過");
        adminCourseApplicationMapper.update(adminCourseApplication, wrapper);
    }

    @Override
    public IPage<AdminCourseApplication> getFinishedAduit(int currentPage, int limit) {
        IPage<AdminCourseApplication> applicationPage = new Page<>(currentPage, limit);
        QueryWrapper<AdminCourseApplication> wrapper = new QueryWrapper<>();
        wrapper.ne("result","未审核");
        applicationPage = adminCourseApplicationMapper.selectPage(applicationPage, wrapper);
        return applicationPage;
    }

    @Override
    public IPage<AdminCourseApplication> getFinishedAduitByKey(int currentPage, int limit, String key, String keyword) {
        IPage<AdminCourseApplication> applicationPage = new Page<>(currentPage, limit);
        QueryWrapper<AdminCourseApplication> wrapper = new QueryWrapper<>();
        wrapper.like(key, keyword);
        wrapper.ne("result","未审核");
        applicationPage = adminCourseApplicationMapper.selectPage(applicationPage, wrapper);
        return applicationPage;
    }

    @Override
    public IPage<AdminCourseApplication> getDealAduit(int currentPage, int limit) {
        IPage<AdminCourseApplication> applicationPage = new Page<>(currentPage, limit);
        QueryWrapper<AdminCourseApplication> wrapper = new QueryWrapper<>();
        wrapper.eq("result","未审核");
        applicationPage = adminCourseApplicationMapper.selectPage(applicationPage, wrapper);
        return applicationPage;
    }

    @Override
    public IPage<AdminCourseApplication> getDealAduitByKey(int currentPage, int limit, String key, String keyword) {
        IPage<AdminCourseApplication> applicationPage = new Page<>(currentPage, limit);
        QueryWrapper<AdminCourseApplication> wrapper = new QueryWrapper<>();
        wrapper.like(key, keyword);
        wrapper.eq("result","未审核");
        applicationPage = adminCourseApplicationMapper.selectPage(applicationPage, wrapper);
        return applicationPage;
    }
}
