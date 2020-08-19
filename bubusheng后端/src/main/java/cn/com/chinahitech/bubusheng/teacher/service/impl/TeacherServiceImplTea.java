package cn.com.chinahitech.bubusheng.teacher.service.impl;

import cn.com.chinahitech.bubusheng.teacher.entity.Teacher;
import cn.com.chinahitech.bubusheng.teacher.mapper.TeaTeacherMapper;
import cn.com.chinahitech.bubusheng.teacher.service.TeaITeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TeacherServiceImplTea extends ServiceImpl<TeaTeacherMapper, Teacher> implements TeaITeacherService {
    @Autowired
    private TeaTeacherMapper tea;

    @Override
    public Teacher getAccount(int id) {
        QueryWrapper wrapper = new QueryWrapper();
        //wrapper.like(列名，值)
        wrapper.eq("teacherId",id);
        Teacher usrinfo=tea.selectOne(wrapper);
        return usrinfo;
    }


    @Override
    public int signup(int teaid, String name, String phone, String password) {
//        QueryWrapper wrapper = new QueryWrapper();
//        //wrapper.like(列名，值)
//        wrapper.eq("teacherId",teacherid);
//        if(wrapper == null){
//            return 0;
//        }
        //else {
        Teacher ateacher=new Teacher(teaid,name,phone,password,0);

        save(ateacher);
        return 1;
        //}
    }
}
