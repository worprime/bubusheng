package cn.com.chinahitech.bubusheng.course.service;

import cn.com.chinahitech.bubusheng.course.entity.CouCoursedata;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hourui
 * @since 2020-08-12
 */
public interface ICouCoursedataService extends IService<CouCoursedata> {


    Integer insertCourseData(Integer classId ,Integer chapter,MultipartFile ppt ,MultipartFile document) throws IOException;
    Integer insertVideo(Integer classId , Integer chapter , MultipartFile video) throws IOException;
    Integer insertExerciseAndAnswer(Integer classId , Integer chapter , String exercise,String answer);
//    List<CouCoursedata> getCourseDataListByClassId(int classId);
//    CouCoursedata getCourseDataByIdAndChapter(int classId, int chapter);
}
