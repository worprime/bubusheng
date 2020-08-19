package cn.com.chinahitech.bubusheng.administrator.controller;


import cn.com.chinahitech.bubusheng.administrator.entity.Administrator;
import cn.com.chinahitech.bubusheng.administrator.service.IAdministratorService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2020-08-10
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class
AdministratorController {
    @Autowired
    private IAdministratorService administratorService;

    @RequestMapping(value = "/Login")
    public String login(String account, String password, String uid) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (uid != null) {
            try {
                map.put("isExist", administratorService.adminLogin(uid));
                map.put("status", 200);
            } catch (Exception e) {
                map.put("status", 500);
            }
        } else {
            Administrator administrator = administratorService.adminLogin(account, password);
            try {
                if (administrator.getUid() != null) {
                    map.put("uid", administrator.getUid());
                    map.put("isExist", true);
                } else {
                    map.put("isExist", false);
                }
                map.put("status", 200);
            } catch (Exception e) {
                map.put("status", 500);
            }

        }
        return JSON.toJSONString(map);
    }
}
