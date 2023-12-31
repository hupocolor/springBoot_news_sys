package hl.hjc.newsdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import hl.hjc.newsdemo.dto.LoginDto;
import hl.hjc.newsdemo.dto.UserDto;
import hl.hjc.newsdemo.entity.NewsUsers;
import hl.hjc.newsdemo.service.NewsUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    NewsUsersService usersService;
    @PostMapping("/login")
    public ResponseEntity<LoginDto> login(@RequestBody NewsUsers user){
        return usersService.login(user);
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody NewsUsers user){
        return usersService.register(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("token") String token){
        return usersService.logout(token);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<UserDto>> getUsers(Integer current, Integer size, @RequestHeader("token") String token){
        return usersService.getUsers(current,size,token);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserDto userDto,@RequestHeader("token") String token){
        return usersService.updateUser(userDto,token);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delUser(@PathVariable("id") Integer id,@RequestHeader("token") String token){
        return usersService.delUser(id,token);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsUsers> getUserById(@PathVariable("id") Integer id,@RequestHeader("token") String token){
        return usersService.getUserById(id,token);
    }

}
