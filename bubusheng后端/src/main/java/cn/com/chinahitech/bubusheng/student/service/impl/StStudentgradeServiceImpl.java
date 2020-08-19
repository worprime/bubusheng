package cn.com.chinahitech.bubusheng.student.service.impl;

import cn.com.chinahitech.bubusheng.student.entity.StStudentgrade;
import cn.com.chinahitech.bubusheng.student.mapper.StStudentgradeMapper;
import cn.com.chinahitech.bubusheng.student.service.StIStudentgradeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
@Service
public class StStudentgradeServiceImpl extends ServiceImpl<StStudentgradeMapper, StStudentgrade> implements StIStudentgradeService {

    @Autowired
    private StStudentgradeMapper studentGradeMapper;

    //1.新增学生分数
    @Override
    public boolean insertStudentGrade(int stuId,int classId,int score){
        UpdateWrapper<StStudentgrade> wrapper=new UpdateWrapper();
        wrapper.eq("studentId",stuId)
                .eq("classId",classId);
        StStudentgrade grade=new StStudentgrade();
        grade.setScore(score);
        boolean i=update(grade,wrapper);
        return i;
    };
    //2.更改学生分数
    @Override
    public boolean updateStudentGrade(int stuId,int classId,int score){
        UpdateWrapper<StStudentgrade> wrapper=new UpdateWrapper();
        wrapper.eq("studentId",stuId)
                .eq("classId",classId);
        StStudentgrade grade=new StStudentgrade();
        grade.setScore(score);
        boolean i=update(grade,wrapper);
        return i;
    };
    //3.根据id和课程查询分数
    @Override
    public int findStudentGradeById(String classId,String studentId){
        QueryWrapper<StStudentgrade> wrapper=new QueryWrapper();
        wrapper.eq("studentId",studentId)
                .eq("classId",classId);
        StStudentgrade result=studentGradeMapper.selectOne(wrapper);
        return result.getScore();
    };
    //4.根据课程id查找分数
    @Override
    public List<StStudentgrade> findStudentGradeByClassId(int classId){
        QueryWrapper<StStudentgrade> wrapper=new QueryWrapper();
        wrapper.eq("classId",classId);
        List<StStudentgrade> result=studentGradeMapper.selectList(wrapper);
        return result;
    }
    ;
    //5.根据学生id查找分数
    @Override
    public List<StStudentgrade> getStudentGrade(int stuId){
        QueryWrapper<StStudentgrade> wrapper=new QueryWrapper();
        wrapper.eq("studentId",stuId);
        List<StStudentgrade> result=studentGradeMapper.selectList(wrapper);
        return result;
    };
}
