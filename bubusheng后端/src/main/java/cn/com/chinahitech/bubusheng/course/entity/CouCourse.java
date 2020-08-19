package cn.com.chinahitech.bubusheng.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class CouCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程编号
     */
    @TableId(value = "classId", type = IdType.AUTO)
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

    public void setClassName(String className) {
        this.className = className;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setBeginning(String beginning) {
        this.beginning = beginning;
    }

    public void setType(String type) {
        this.type = type;
    }
}
