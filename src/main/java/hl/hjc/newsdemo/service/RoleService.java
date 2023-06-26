package hl.hjc.newsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hl.hjc.newsdemo.entity.Role;
import org.springframework.http.ResponseEntity;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2023-06-21 17:13:58
 */
public interface RoleService extends IService<Role> {

    ResponseEntity getRoleNow(String token);
}

