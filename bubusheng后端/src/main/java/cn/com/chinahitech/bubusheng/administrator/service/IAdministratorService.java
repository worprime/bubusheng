package cn.com.chinahitech.bubusheng.administrator.service;

import cn.com.chinahitech.bubusheng.administrator.entity.Administrator;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
public interface IAdministratorService extends IService<Administrator> {
    Administrator adminLogin(String username,String password);
    boolean adminLogin(String uid);
}
