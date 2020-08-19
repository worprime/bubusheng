package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClass;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClassVo;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdminStudentClassMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdminStudentClassService;
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
public class AdminStudentClassServiceImpl extends ServiceImpl<AdminStudentClassMapper, AdminStudentClass> implements IAdminStudentClassService {

    @Autowired
    private AdminStudentClassMapper adminStudentClassMapper;

    @Override
    public IPage<AdminStudentClassVo> getClassStudent(int currentPage, int limit, String id) {
        IPage<AdminStudentClassVo> adminStudentClassVoPage = new Page<>(currentPage,limit);
        adminStudentClassVoPage = adminStudentClassMapper.selectByMyWrapper(adminStudentClassVoPage,id);
        return adminStudentClassVoPage;
    }
}
