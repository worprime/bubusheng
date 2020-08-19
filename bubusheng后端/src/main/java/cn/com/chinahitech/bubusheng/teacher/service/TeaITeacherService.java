package cn.com.chinahitech.bubusheng.teacher.service;

import cn.com.chinahitech.bubusheng.teacher.entity.Course;
import cn.com.chinahitech.bubusheng.teacher.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiangjiayao
 * @since 2020-08-11
 */
public interface TeaITeacherService extends IService<Teacher> {
    Teacher getAccount(int id);
    int signup(int teaid,String name,String phone,String password);
}
