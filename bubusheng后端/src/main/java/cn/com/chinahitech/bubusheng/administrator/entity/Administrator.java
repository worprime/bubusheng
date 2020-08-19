package cn.com.chinahitech.bubusheng.administrator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId("Id")
    private Integer Id;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 管理员用戶名
     */
    @TableId("account")
    private String account;

    @TableId("uid")
    private String uid;

    public Integer getId(){
        return this.Id;
    }

    public String getUid(){return this.uid;}

}
