package cn.com.chinahitech.bubusheng.course.entity;

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
 * @author hourui
 * @since 2020-08-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("studentgrade")
public class CouStudentgrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("studentId")
    private Integer studentId;

    @TableField("classId")
    private Integer classId;

    private Integer score;

    private String annotation;

    private String answer;

    private String state;

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setState(String state) {
        this.state = state;
    }
}
