package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudent;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-12
 */
public interface IAdminStudentService extends IService<AdminStudent> {
    IPage<AdminStudent> getAllStudent(int currentPage, int limit);
    AdminStudent getStudentById(String id);
    IPage<AdminStudent> getStudentByKey(int currentPage, int limit, String key, String keyword);
    void deleteStudent(String id) ;
}
