package cn.com.chinahitech.bubusheng.course.service.impl;

import cn.com.chinahitech.bubusheng.course.entity.CouStudentgrade;
import cn.com.chinahitech.bubusheng.course.mapper.CouStudentgradeMapper;
import cn.com.chinahitech.bubusheng.course.service.ICouStudentgradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hourui
 * @since 2020-08-15
 */
@Service
public class CouStudentgradeServiceImpl extends ServiceImpl<CouStudentgradeMapper, CouStudentgrade> implements ICouStudentgradeService {

    @Autowired
    private CouStudentgradeMapper studentgradeMapper;

    @Override
    public IPage<CouStudentgrade> getStudentGrade(Integer classId, Integer currentPage, Integer limit) {
        IPage<CouStudentgrade> studentGradeIPage = new Page<>(currentPage,limit);
        QueryWrapper<CouStudentgrade> wrapper = new QueryWrapper<>();
        wrapper.eq("classId",classId);
        studentGradeIPage = studentgradeMapper.selectPage(studentGradeIPage,wrapper);
        return studentGradeIPage;

    }

    @Override
    public Integer setStudentGrade(Integer studentId, Integer classId, Integer score, String annotation,String answer) {
        UpdateWrapper<CouStudentgrade> wrapper = new UpdateWrapper<>();
        wrapper.eq("classId" ,classId);
        wrapper.eq("studentId",studentId);
        CouStudentgrade StudentGrade = new CouStudentgrade();
        StudentGrade.setScore(score);
        StudentGrade.setAnnotation(annotation);
        StudentGrade.setAnswer(answer);
        StudentGrade.setState("1");
        int i = studentgradeMapper.update(StudentGrade,wrapper);
        return i;
    }
}
