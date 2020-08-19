package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminTeacher;
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
public interface IAdminTeacherService extends IService<AdminTeacher> {
    IPage<AdminTeacher> getAllTeacher(int currentPage, int limit);
    AdminTeacher getTeacherById(String id);
    IPage<AdminTeacher> getTeacherByKey(int currentPage, int limit, String key, String keyword);
    void deleteTeacher(String id);
}
