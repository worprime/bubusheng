package cn.com.chinahitech.bubusheng.teacher.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;


@Data
public class MyStudentinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 学生姓名
     */

    private String studentName;

    /**
     * 学生性别
     */
    private String sex;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;


    private Integer classId;

    /**
     * 课程名
     */
    private String className;


    private Integer score;
}
