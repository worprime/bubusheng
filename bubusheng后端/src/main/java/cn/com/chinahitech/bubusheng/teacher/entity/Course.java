package cn.com.chinahitech.bubusheng.teacher.entity;

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
 * @author zhufu
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class Course implements Serializable {

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


}
