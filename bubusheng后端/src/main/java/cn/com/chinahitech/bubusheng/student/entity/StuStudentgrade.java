package cn.com.chinahitech.bubusheng.student.entity;

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
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("studentgrade")
public class StuStudentgrade implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "studentId",type = IdType.INPUT)
    private Integer studentId;

    @TableField("classId")
    private Integer classId;

    private Integer score;

    private String annotation;

    private String answer;

    private Integer state;

    public int getscore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score=score;
    }

    public void setStudentId(int studentId)
    {
        this.studentId=studentId;
    }

    public void setClassId(int classId)
    {
        this.classId=classId;
    }

    public StuStudentgrade(){};

    public StuStudentgrade(int stuId, int classId,int score,String annotation,String answer,int state)
    {
        this.studentId=stuId;
        this.classId=classId;
        this.score=score;
        this.annotation=annotation;
        this.answer=answer;
        this.state=state;
    }

}
