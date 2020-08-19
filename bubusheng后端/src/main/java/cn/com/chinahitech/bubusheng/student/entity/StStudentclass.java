package cn.com.chinahitech.bubusheng.student.entity;

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
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("studentclass")
public class StStudentclass implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生id
     */
    @TableId("studentId")
    private Integer studentId;

    /**
     * 课程id
     */
    @TableField("classId")
    private Integer classId;


}
