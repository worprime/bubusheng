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
@TableName("studentgrade")
public class AdminStudentgradeVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("studentId")
    private Integer studentId;

    @TableField("classId")
    private Integer classId;

    private Integer score;

    private String className;

    private String studentName;
}