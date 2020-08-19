package cn.com.chinahitech.bubusheng.student.mapper;

import cn.com.chinahitech.bubusheng.student.entity.StuCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-12
 */
@Mapper
@Repository
public interface StuCourseMapper extends BaseMapper<StuCourse> {

}
