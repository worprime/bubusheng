package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClass;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClassVo;
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

public interface IAdminStudentClassService extends IService<AdminStudentClass> {

    IPage<AdminStudentClassVo> getClassStudent(int currentPage, int limit, String id);
}
