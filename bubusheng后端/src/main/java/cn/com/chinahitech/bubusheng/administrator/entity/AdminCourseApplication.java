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
@TableName("courseapplication")
public class AdminCourseApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("Id")
    private Integer Id;

    /**
     * 课程名
     */
    @TableField("className")
    private String className;

    /**
     * 授课老师id
     */
    @TableField("teacherId")
    private Integer teacherId;

    /**
     * 授课老师名称
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 课程简介
     */
    private String intro;

    /**
     * 课程类型
     */
    private String type;

    /**
     * 开课时间
     */
    private String beginning;

    /**
     * 审核结果
     */
    private String result;

    public Integer getTeacherId() {
        return teacherId;
    }

    public String getBeginning() {
        return beginning;
    }

    public String getClassName() {
        return className;
    }

    public String getIntro() {
        return intro;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getType() {
        return type;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
