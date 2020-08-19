package cn.com.chinahitech.bubusheng.course.entity;

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
 * @author hourui
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("notice")
public class CouNotice implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableField("classId")
    private Integer classId;

    private String notice;

    private String time;

    @TableField("noticeName")
    private String noticeName;

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }
}
