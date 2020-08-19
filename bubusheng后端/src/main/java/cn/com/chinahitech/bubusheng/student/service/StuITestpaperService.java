package cn.com.chinahitech.bubusheng.student.service;

import cn.com.chinahitech.bubusheng.student.entity.StuTestpaper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-14
 */
public interface StuITestpaperService extends IService<StuTestpaper> {
    StuTestpaper getStuTestpaperByClassId(int classId);
}
