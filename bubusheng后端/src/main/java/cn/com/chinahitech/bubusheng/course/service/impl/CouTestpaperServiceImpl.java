package cn.com.chinahitech.bubusheng.course.service.impl;

import cn.com.chinahitech.bubusheng.course.entity.CouTestpaper;
import cn.com.chinahitech.bubusheng.course.mapper.CouTestpaperMapper;
import cn.com.chinahitech.bubusheng.course.service.ICouTestpaperService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hourui
 * @since 2020-08-14
 */
@Service
public class CouTestpaperServiceImpl extends ServiceImpl<CouTestpaperMapper, CouTestpaper> implements ICouTestpaperService {

    @Autowired
    private CouTestpaperMapper testpaperMapper;

    @Override
    public Integer insertTestpaper(Integer classId, MultipartFile test, String testTime, String deadline) throws IOException {

        String url = "https://39.98.127.39:8084";
        String testName = test.getOriginalFilename();
        String dirPath = "/usr/share/nginx/html/group15";
        String testPath = dirPath + File.separator + "test";
        File testDir = new File(testPath);
        if(!testDir.exists()){
            testDir.mkdir();
        }
        File target = new File(testDir,testName);
        test.transferTo(target);
        CouTestpaper testpaper = new CouTestpaper();
        testpaper.setClassId(classId);
        testpaper.setTest(url+"/"+testDir);
        testpaper.setTesttime(testTime);
        testpaper.setDeadline(deadline);
        int i = testpaperMapper.insert(testpaper);
        return i;
    }
}
