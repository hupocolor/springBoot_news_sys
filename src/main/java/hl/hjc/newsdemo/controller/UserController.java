package hl.hjc.newsdemo.controller;

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
    public ResponseEntity login(@RequestBody NewsUsers user){
        return usersService.login(user);
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody NewsUsers user){
        return usersService.register(user);
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("token") String token){
        return usersService.logout(token);
    }

    @GetMapping("/list")
    public ResponseEntity getUsers(Integer current,Integer size,@RequestHeader("token") String token){
        return usersService.getUsers(current,size,token);
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDto userDto,@RequestHeader("token") String token){
        return usersService.updateUser(userDto,token);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delUser(@PathVariable("id") Integer id,@RequestHeader("token") String token){
        return usersService.delUser(id,token);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id,@RequestHeader("token") String token){
        return usersService.getUserById(id,token);
    }

}
