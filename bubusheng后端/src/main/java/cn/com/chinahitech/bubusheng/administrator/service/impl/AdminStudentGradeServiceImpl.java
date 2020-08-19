package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentgrade;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentgradeVo;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminStudentGradeMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminStudentgradeService;
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
public class AdminStudentGradeServiceImpl extends ServiceImpl<AdminStudentGradeMapper, AdminStudentgrade> implements IAdminStudentgradeService {
    @Autowired
    private AdminStudentGradeMapper adminStudentGradeMapper;



    @Override
    public IPage<AdminStudentgradeVo> getStudentGrade(int currentPage, int limit, String id) {
        IPage<AdminStudentgradeVo> adminStudentgradeVoPage = new Page<>(currentPage,limit);
        adminStudentgradeVoPage = adminStudentGradeMapper.selectByMyWrapper(adminStudentgradeVoPage,id);
        return adminStudentgradeVoPage;
    }
}
