package hl.hjc.newsdemo.controller;

import hl.hjc.newsdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("/list")
    public ResponseEntity getRoleList(){
        return ResponseEntity.ok(roleService.list());
    }
    @GetMapping("/now")
    public ResponseEntity getRoleNow(@RequestHeader("token") String token){
        return roleService.getRoleNow(token);
    }
}
