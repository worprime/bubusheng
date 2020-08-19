package cn.com.chinahitech.bubusheng.student.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("testpaper")
public class StuTestpaper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷对应课程编号
     */
    @TableId("classId")
    private Integer classId;

    /**
     * 考试试卷存储地址
     */
    private String test;

    /**
     * 考试时间
     */
    private String testtime;

    /**
     * 考试截止时间
     */
    private String deadline;


    public void setDeadline(String deadline)
    {
        this.deadline=deadline;
    }

    public String getDeadline()
    {
        return deadline;
    }
}
