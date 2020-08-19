package cn.com.chinahitech.bubusheng.administrator.service.impl;

import cn.com.chinahitech.bubusheng.administrator.entity.Administrator;
import cn.com.chinahitech.bubusheng.administrator.mapper.AdministratorMapper;
import cn.com.chinahitech.bubusheng.administrator.service.IAdministratorService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements IAdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator adminLogin(String username, String password) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("account",username);
        wrapper.eq("password",password);
        Administrator administrator = administratorMapper.selectOne(wrapper);
        return administrator;
    }

    @Override
    public boolean adminLogin(String uid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uid",uid);
        int count = administratorMapper.selectCount(wrapper);
        return (count == 0)?false:true;
    }


}
