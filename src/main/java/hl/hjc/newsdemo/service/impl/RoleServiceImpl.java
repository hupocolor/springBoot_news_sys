package hl.hjc.newsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hl.hjc.newsdemo.dao.RoleDao;
import hl.hjc.newsdemo.entity.Role;
import hl.hjc.newsdemo.service.RoleService;
import hl.hjc.newsdemo.utils.LoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2023-06-21 17:13:58
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
    @Autowired
    LoginProperties loginProperties;
    @Override
    public ResponseEntity getRoleNow(@RequestHeader("token") String token) {
        Role role = getById(loginProperties.getRole(token));
        return ResponseEntity.ok(role);
    }
}

