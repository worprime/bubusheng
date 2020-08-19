package cn.com.chinahitech.bubusheng.course.service;

import cn.com.chinahitech.bubusheng.course.entity.CouNotice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
public interface ICouNoticeService extends IService<CouNotice> {
    Integer insertNotice(Integer classId,String notice ,String noticeName ,String time);

}
