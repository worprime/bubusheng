package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourseApplication;
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
public interface IAdminCourseApplicationService extends IService<AdminCourseApplication> {
    IPage<AdminCourseApplication> getAllAduit(int currentPage, int limit);
    AdminCourseApplication getAduitById(String id);
    IPage<AdminCourseApplication> getAduitByKey(int currentPage, int limit, String key, String keyword);
    void sumbitAduit(String id);
    void unsumbitAduit(String id);
    IPage<AdminCourseApplication> getFinishedAduit(int currentPage, int limit);
    IPage<AdminCourseApplication> getFinishedAduitByKey(int currentPage, int limit, String key, String keyword);
    IPage<AdminCourseApplication> getDealAduit(int currentPage, int limit);
    IPage<AdminCourseApplication> getDealAduitByKey(int currentPage, int limit, String key, String keyword);
}
