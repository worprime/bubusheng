package cn.com.chinahitech.bubusheng.student.service.impl;

import cn.com.chinahitech.bubusheng.student.entity.StuTestpaper;
import cn.com.chinahitech.bubusheng.student.mapper.StuTestpaperMapper;
import cn.com.chinahitech.bubusheng.student.service.StuITestpaperService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-14
 */
@Service
public class StuTestpaperServiceImpl extends ServiceImpl<StuTestpaperMapper, StuTestpaper> implements StuITestpaperService {

    @Autowired
    private StuTestpaperMapper stuTestpaperMapper;

    @Override
    public StuTestpaper getStuTestpaperByClassId(int classId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("classId",classId);
        StuTestpaper stuTestpaper = stuTestpaperMapper.selectOne(wrapper);
        return stuTestpaper;
    }
}
