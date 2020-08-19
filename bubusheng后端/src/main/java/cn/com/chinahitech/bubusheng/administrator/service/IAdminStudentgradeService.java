package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentgrade;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentgradeVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
public interface IAdminStudentgradeService extends IService<AdminStudentgrade> {
    IPage<AdminStudentgradeVo> getStudentGrade(int currentPage, int limit, String id);
}
