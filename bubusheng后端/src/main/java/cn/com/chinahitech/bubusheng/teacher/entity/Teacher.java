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
@TableName("teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Teacher(Integer teacherId, String teacherName, String phone, String password, Integer flag) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.phone = phone;
        this.password = password;
        this.flag = flag;
    }

    /**
     *
     * 老师id
     */
    @TableId(value = "teacherId", type = IdType.INPUT)
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
    private Integer flag;


}
