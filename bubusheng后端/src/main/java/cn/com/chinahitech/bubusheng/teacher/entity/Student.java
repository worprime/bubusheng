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
@TableName("student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId("studentId")
    private Integer studentId;

    /**
     * 学生姓名
     */
    @TableField("studentName")
    private String studentName;

    /**
     * 学生性别
     */
    private  String sex;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 逻辑删除值
     */
    private Integer flag;


}
