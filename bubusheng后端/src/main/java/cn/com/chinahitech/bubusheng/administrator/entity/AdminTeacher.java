package cn.com.chinahitech.bubusheng.administrator.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * @since 2020-08-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("teacher")
public class AdminTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 老师id
     */
    @TableId("teacherId")
    private Integer teacherId;

    /**
     * 老师名
     */
    @TableField("teacherName")
    private String teacherName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 逻辑删除值
     */
    @TableLogic
    private Integer flag;


}
