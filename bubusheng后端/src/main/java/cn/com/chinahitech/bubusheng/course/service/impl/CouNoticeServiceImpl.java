package cn.com.chinahitech.bubusheng.course.service.impl;

import cn.com.chinahitech.bubusheng.course.entity.CouNotice;
import cn.com.chinahitech.bubusheng.course.mapper.CouNoticeMapper;
import cn.com.chinahitech.bubusheng.course.service.ICouNoticeService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
@Service
public class CouNoticeServiceImpl extends ServiceImpl<CouNoticeMapper, CouNotice> implements ICouNoticeService {

    @Autowired
    private CouNoticeMapper noticeMapper;

    @Override
    public Integer insertNotice(Integer classId, String notice, String noticeName, String time) {


        CouNotice notice1 = new CouNotice();
        notice1.setClassId(classId);
        notice1.setNotice(notice);
        notice1.setNoticeName(noticeName);
        notice1.setTime(time);
        int i = noticeMapper.insert(notice1);
        return i;
    }
}
