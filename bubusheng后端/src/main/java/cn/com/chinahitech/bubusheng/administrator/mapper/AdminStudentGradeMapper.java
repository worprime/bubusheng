package cn.com.chinahitech.bubusheng.administrator.mapper;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentgrade;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentgradeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
@Repository
public interface AdminStudentGradeMapper extends BaseMapper<AdminStudentgrade> {
    /**
     *
     * 如果自定义的方法还希望能够使用MP提供的Wrapper条件构造器，则需要如下写法
     *
     * @param page,studentId
     * @return
     */
    @Select("SELECT course.classId,course.className,studentgrade.score FROM course , studentgrade where studentgrade.studentid=#{id} and course.classId = studentgrade.classId")
    IPage<AdminStudentgradeVo> selectByMyWrapper(IPage<AdminStudentgradeVo> page, String id);

}
