package cn.com.chinahitech.bubusheng.course.service.impl;

import cn.com.chinahitech.bubusheng.course.entity.CouCoursedata;
import cn.com.chinahitech.bubusheng.course.mapper.CouCoursedataMapper;
import cn.com.chinahitech.bubusheng.course.service.ICouCoursedataService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hourui
 * @since 2020-08-12
 */
@Service
public class CouCoursedataServiceImpl extends ServiceImpl<CouCoursedataMapper, CouCoursedata> implements ICouCoursedataService {

    @Autowired
    private CouCoursedataMapper coursedataMapper;





    @Override
    public Integer insertCourseData(Integer classId, Integer chapter, MultipartFile ppt, MultipartFile document) throws IOException {

        UpdateWrapper<CouCoursedata> wrapper = new UpdateWrapper<>();
        wrapper.eq("classId" ,classId);
        wrapper.eq("chapters",chapter);
        String url = "https://39.98.127.39:8084";
        String pptName = ppt.getOriginalFilename();
        String dirPath = "/usr/share/nginx/html/group15";
        String pptPath = dirPath + File.separator + "ppt";
        File pptDir = new File(pptPath);
        if(!pptDir.exists()){
            pptDir.mkdir();
        }
        File target = new File(pptDir,pptName);
        ppt.transferTo(target);
        String documentName = document.getOriginalFilename();
        String documentPath = dirPath + File.separator + "document";
        File documentDir = new File(documentPath);
        if(!pptDir.exists()){
            pptDir.mkdir();
        }
        File target1 = new File(documentDir,documentName);
        ppt.transferTo(target1);
        CouCoursedata coursedata = new CouCoursedata();
        coursedata.setClassId(classId);
        coursedata.setChapters(chapter);
        coursedata.setPpt(url+"/"+pptDir+"/"+pptName);
        coursedata.setDocument(url+"/"+documentDir+"/"+documentName);
        Integer i;
        if(coursedataMapper.update(coursedata,wrapper) != 1){
            i = coursedataMapper.update(coursedata,wrapper);
        } else {
            i = coursedataMapper.insert(coursedata);
        }
        return i;
    }

    @Override
    public Integer insertVideo(Integer classId, Integer chapter, MultipartFile video) throws IOException {


        UpdateWrapper<CouCoursedata> wrapper = new UpdateWrapper<>();
        wrapper.eq("classId" ,classId);
        wrapper.eq("chapters",chapter);
        String url = "https://39.98.127.39:8084";
        String videoName = video.getOriginalFilename();
        String dirPath = "F:\\Program Files(x86)\\nginx-1.18.0\\html/group15";
        String videoPath = dirPath + File.separator + "video";
        File videoDir = new File(videoPath);
        if(!videoDir.exists()){
            videoDir.mkdir();
        }
        File target = new File(videoDir,videoName);
        video.transferTo(target);
        CouCoursedata coursedata = new CouCoursedata();
        coursedata.setClassId(classId);
        coursedata.setChapters(chapter);
        coursedata.setVideo(url+"/"+videoDir+"/"+videoName);
        Integer i;
        if(coursedataMapper.update(coursedata,wrapper) != 1){
            i = coursedataMapper.update(coursedata,wrapper);
        } else {
            i = coursedataMapper.insert(coursedata);
        }
        return i;
    }

    @Override
    public Integer insertExerciseAndAnswer(Integer classId, Integer chapter, String exercise, String answer) {
        UpdateWrapper<CouCoursedata> wrapper = new UpdateWrapper<>();
        wrapper.eq("classId" ,classId);
        wrapper.eq("chapters",chapter);
        CouCoursedata coursedata = new CouCoursedata();
        coursedata.setClassId(classId);
        coursedata.setChapters(chapter);
        coursedata.setExercise(exercise);
        coursedata.setAnswer(answer);
        Integer i;
        if(coursedataMapper.update(coursedata,wrapper) != 1){
            i = coursedataMapper.update(coursedata,wrapper);
        } else {
            i = coursedataMapper.insert(coursedata);
        }
        return i;

    }


//    @Override
//    public List<CouCoursedata> getCourseDataListByClassId(int classId) {
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.eq("classId",classId);
//        List<CouCoursedata> coursedataList = coursedataMapper.selectList(wrapper);
//        return coursedataList;
//    }
//
//    @Override
//    public CouCoursedata getCourseDataByIdAndChapter(int classId, int chapter) {
//        QueryWrapper<CouCoursedata> wrapper = new QueryWrapper<>();
//        wrapper.eq("classId",classId);
//        wrapper.eq("chapters",chapter);
//        CouCoursedata coursedata = coursedataMapper.selectOne(wrapper);
//        return coursedata;
//    }
}
