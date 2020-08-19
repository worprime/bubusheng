package cn.com.chinahitech.bubusheng.course.service;

import cn.com.chinahitech.bubusheng.course.entity.CouTestpaper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
public interface ICouTestpaperService extends IService<CouTestpaper> {
    Integer insertTestpaper(Integer classId, MultipartFile test, String testTime, String deadline) throws IOException;
}
