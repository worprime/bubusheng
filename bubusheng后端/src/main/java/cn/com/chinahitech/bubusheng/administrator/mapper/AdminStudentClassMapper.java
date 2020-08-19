package cn.com.chinahitech.bubusheng.administrator.mapper;

import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClass;
import cn.com.chinahitech.bubusheng.administrator.entity.AdminStudentClassVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
@Repository
public interface AdminStudentClassMapper extends BaseMapper<AdminStudentClass> {
    @Select("SELECT studentgrade.score,student.studentName,student.studentId FROM (select * from studentclass where studentclass.classid=#{id}) a left join studentgrade on a.studentId = studentgrade.studentId left join student on a.studentId = student.studentId where  studentgrade.classid = #{id}")
    IPage<AdminStudentClassVo> selectByMyWrapper(IPage<AdminStudentClassVo> page, String id);

}
