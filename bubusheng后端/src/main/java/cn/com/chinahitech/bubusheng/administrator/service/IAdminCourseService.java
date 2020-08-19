package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminCourse;
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
public interface IAdminCourseService extends IService<AdminCourse> {
    IPage<AdminCourse> getAllCourse(int currentPage, int limit);
    AdminCourse getCourseById(String id);
    IPage<AdminCourse> getCourseByKey(int currentPage, int limit, String key, String keyword);
    IPage<AdminCourse> getCourseByTeacherId(int currentPage, int limit, String id);
}
