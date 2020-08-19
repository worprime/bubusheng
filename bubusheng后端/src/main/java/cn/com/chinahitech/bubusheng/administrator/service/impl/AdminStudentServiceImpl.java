package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudent;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminStudentMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminStudentService;
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
public class AdminStudentServiceImpl extends ServiceImpl<AdminStudentMapper, AdminStudent> implements IAdminStudentService {

    @Autowired
    private  AdminStudentMapper adminStudentMapper;

    @Override
    public IPage<AdminStudent> getAllStudent(int currentPage, int limit) {
        IPage<AdminStudent> studentPage = new Page<>(currentPage,limit);
        QueryWrapper<AdminStudent> wrapper = new QueryWrapper<>();
        wrapper.select("studentId","studentName","sex","age","phone");
        studentPage = adminStudentMapper.selectPage(studentPage,wrapper);
        return studentPage;
    }

    @Override
    public AdminStudent getStudentById(String id) {
        QueryWrapper<AdminStudent> wrapper = new QueryWrapper<>();
        wrapper.eq("studentId",id);
        wrapper.select("studentId","studentName","sex","age","phone");
        AdminStudent adminStudent = adminStudentMapper.selectOne(wrapper);
        return adminStudent;
    }

    @Override
    public IPage<AdminStudent> getStudentByKey(int currentPage, int limit, String key, String keyword) {
        IPage<AdminStudent> studentPage = new Page<>(currentPage,limit);
        QueryWrapper<AdminStudent> wrapper = new QueryWrapper<>();
        wrapper.eq(key,keyword);
        studentPage = adminStudentMapper.selectPage(studentPage,wrapper);
        return studentPage;
    }

    @Override
    public void deleteStudent(String id) {
        UpdateWrapper<AdminStudent> wrapper = new UpdateWrapper<>();
        wrapper.eq("studentId",id);
        adminStudentMapper.delete(wrapper);
    }
}
