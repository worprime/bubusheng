package cn.com.chinahitech.bubusheng.student.entity;

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
 * @author zhouzihao
 * @since 2020-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("notice")
public class StuNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("classId")
    private Integer classId;

    private String notice;

    private String time;

    @TableField("noticeName")
    private String noticeName;


}
