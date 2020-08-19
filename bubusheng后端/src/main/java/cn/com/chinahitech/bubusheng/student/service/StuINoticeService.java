package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.StuNotice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-12
 */
public interface StuINoticeService extends IService<StuNotice> {
    public List<StuNotice> getNoticeByClassId(int ClassId);
}
