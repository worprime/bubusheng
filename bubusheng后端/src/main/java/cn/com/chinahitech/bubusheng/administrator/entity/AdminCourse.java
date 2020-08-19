package cn.com.chinahitech.bubusheng.administrator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouzihao
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class AdminCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    @TableId("classId")
    private Integer classId;

    /**
     * 课程名
     */
    @TableField("className")
    private String className;

    /**
     * 老师id
     */
    @TableField("teacherId")
    private Integer teacherId;

    /**
     * 老师名
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 课程介绍
     */
    private String intro;

    /**
     * 开课时间
     */
    private String beginning;

    /**
     * 课程类型
     */
    private String type;

    public void setClassName(String className){
        this.className=className;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setType(String type) {
        this.type = type;
    }
}
