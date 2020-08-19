package cn.com.chinahitech.bubusheng.course.service;

import cn.com.chinahitech.bubusheng.course.entity.CouStudentgrade;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hourui
 * @since 2020-08-15
 */
public interface ICouStudentgradeService extends IService<CouStudentgrade> {
    IPage<CouStudentgrade> getStudentGrade(Integer classId , Integer currentPage , Integer limit);
    Integer setStudentGrade(Integer studentId,Integer classId,Integer score,String annotation,String answer);
}
