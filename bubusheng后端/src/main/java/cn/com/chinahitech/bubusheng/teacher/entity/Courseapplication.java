package cn.com.chinahitech.bubusheng.teacher.entity;

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
 * @author zhufu
 * @since 2020-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("courseapplication")
public class Courseapplication implements Serializable {

    private static final long serialVersionUID = 1L;

    public Courseapplication(String className, Integer teacherId, String teacherName, String intro, String type, String beginning) {
        this.className = className;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.intro = intro;
        this.type = type;
        this.beginning = beginning;
    }

    /**
     * 课程id
     */
    @TableId(value = "Id",type = IdType.AUTO)
    private Integer Id;
    /**
     * 课程名
     */
    @TableField("className")
    private String className;

    /**
     * 授课老师id
     */
    @TableField(value = "teacherId")
    private Integer teacherId;

    /**
     * 授课老师名称
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 课程简介
     */
    @TableField("intro")
    private String intro;

    /**
     * 课程类型
     */
    @TableField("type")
    private String type;

    /**
     * 开课时间
     */
    @TableField("beginning")
    private String beginning;

    /**
     * 审核结果
     */
    @TableField("result")
    private String result;


}
