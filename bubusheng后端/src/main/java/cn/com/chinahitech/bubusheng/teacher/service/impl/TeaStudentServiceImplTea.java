package cn.com.chinahitech.bubusheng.teacher.service.impl;

import cn.com.chinahitech.bubusheng.teacher.entity.Student;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaStudentMapper;
import cn.com.chinahitech.bubusheng.teacher.service.TeaIStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-11
 */
@Service
public class TeaStudentServiceImplTea extends ServiceImpl<TeaStudentMapper, Student> implements TeaIStudentService {

}
