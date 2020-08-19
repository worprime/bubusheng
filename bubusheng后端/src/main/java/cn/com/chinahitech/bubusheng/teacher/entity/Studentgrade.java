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
@TableName("studentgrade")
public class Studentgrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("studentId")
    private Integer studentId;

    @TableField("classId")
    private Integer classId;

    private Integer score;

    private String annotation;

    private String answer;

    private Integer state;


}
