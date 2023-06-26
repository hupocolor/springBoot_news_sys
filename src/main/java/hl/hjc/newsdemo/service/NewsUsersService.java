package hl.hjc.newsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import hl.hjc.newsdemo.dto.UserDto;
import hl.hjc.newsdemo.entity.NewsUsers;
import org.springframework.http.ResponseEntity;

/**
 * (NewsUsers)表服务接口
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
public interface NewsUsersService extends IService<NewsUsers> {

    ResponseEntity login(NewsUsers user);

    ResponseEntity register(NewsUsers user);

    ResponseEntity logout(String token);

    ResponseEntity getUsers(Integer current, Integer size, String token);

    ResponseEntity updateUser(UserDto userDto, String token);

    ResponseEntity delUser(Integer id, String token);

    ResponseEntity getUserById(Integer id, String token);
}

