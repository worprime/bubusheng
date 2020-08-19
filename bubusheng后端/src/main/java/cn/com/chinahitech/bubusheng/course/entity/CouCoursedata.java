package cn.com.chinahitech.bubusheng.course.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hourui
 * @since 2020-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("coursedata")
public class CouCoursedata implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableId("classId")
    private Integer classId;

    /**
     * 章节
     */
    private Integer chapters;

    /**
     * 章节名
     */
    private String name;

    /**
     * 教学视频
     */
    private String video;



    /**
     * 文档
     */
    private String document;



    /**
     * 教学ppt
     */
    private String ppt;

    /**
     * 习题
     */
    private String exercise;

    /**
     * 习题答案
     */
    private String answer;

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
