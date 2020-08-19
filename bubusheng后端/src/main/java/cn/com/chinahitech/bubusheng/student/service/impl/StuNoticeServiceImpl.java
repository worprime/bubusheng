package cn.com.chinahitech.bubusheng.student.service.impl;

import cn.com.chinahitech.bubusheng.student.entity.StuNotice;
import cn.com.chinahitech.bubusheng.student.mapper.StuNoticeMapper;
import cn.com.chinahitech.bubusheng.student.service.StuINoticeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-12
 */
@Service
public class StuNoticeServiceImpl extends ServiceImpl<StuNoticeMapper, StuNotice> implements StuINoticeService {
    @Autowired
    private StuNoticeMapper stuNoticeMapper;

    @Override
    public List<StuNotice> getNoticeByClassId(int ClassId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("classId",ClassId);
        List<StuNotice> stuNoticeList = stuNoticeMapper.selectList(wrapper);

        return stuNoticeList;
    }
}
