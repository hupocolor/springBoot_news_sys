package hl.hjc.newsdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import hl.hjc.newsdemo.dao.NewsUsersDao;
import hl.hjc.newsdemo.dto.UserDto;
import hl.hjc.newsdemo.entity.NewsUsers;
import hl.hjc.newsdemo.service.NewsUsersService;
import hl.hjc.newsdemo.service.RoleService;
import hl.hjc.newsdemo.utils.BeanCopyUtils;
import hl.hjc.newsdemo.utils.LoginProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * (NewsUsers)表服务实现类
 *
 * @author makejava
 * @since 2023-06-21 16:14:42
 */
@Service("newsUsersService")
public class NewsUsersServiceImpl extends ServiceImpl<NewsUsersDao, NewsUsers> implements NewsUsersService {

    @Autowired
    LoginProperties loginProperties;
    @Autowired
    RoleService roleService;

    @Override
    public ResponseEntity login(NewsUsers user) {
        LambdaQueryWrapper<NewsUsers> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(NewsUsers::getUname,user.getUname());
        lambdaQueryWrapper.eq(NewsUsers::getUpwd,user.getUpwd());
        NewsUsers newsUsers = getOne(lambdaQueryWrapper);
        if (!Objects.isNull(newsUsers)) {
            //获取token
            String newToken = UUID.randomUUID().toString();
            //若token已经存在，创建新的token
            while (loginProperties.getIsLogin(String.valueOf(newToken))){
                newToken = UUID.randomUUID().toString();
            }
            loginProperties.setIsLogin(newToken, newsUsers);
            Map<String,Object> response = new HashMap<>();
            response.put("user",newsUsers);
            response.put("token",newToken);
            return new ResponseEntity(response,HttpStatus.OK);
        }
        return new ResponseEntity("账号或密码错误",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity register(NewsUsers user) {
        System.out.println(user);
        if (Strings.isBlank(user.getUname())) return new ResponseEntity<>("用户名不能为空",HttpStatus.BAD_REQUEST);
        if (user.getUpwd().length()>16 || user.getUpwd().length()<3) return new ResponseEntity<>("密码长度错误",HttpStatus.BAD_REQUEST);
        LambdaQueryWrapper<NewsUsers> name = new LambdaQueryWrapper<>();
        name.eq(NewsUsers::getUname,user.getUname());
        if(!Objects.isNull(getOne(name))) return new ResponseEntity("已存在用户",HttpStatus.BAD_REQUEST);
        user.setRoleid(2);
        save(user);
        return new ResponseEntity("创建成功",HttpStatus.OK);
    }

    @Override
    public ResponseEntity logout(String token) {
        loginProperties.setIsLogin(token,null);
        return new ResponseEntity<>("退出成功",HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUsers(Integer current, Integer size, String token) {
        if (loginProperties.getRole(token)!=3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        Page<NewsUsers> usersPage = page(new Page<>(current, size));
        List<NewsUsers> newsUsers = usersPage.getRecords();
        List<UserDto> users = BeanCopyUtils.copyBeanList(newsUsers, UserDto.class);
        for (UserDto user : users) {
            user.setRoleName(roleService.getById(user.getRoleid()).getRoleName());
        }
        Page<UserDto> page = new Page<>();
        page.setRecords(users);
        page.setTotal(usersPage.getTotal());
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity updateUser(UserDto userDto, String token) {
        if (loginProperties.getRole(token)!=3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        NewsUsers newsUsers = BeanCopyUtils.copyBean(userDto, NewsUsers.class);
        LambdaQueryWrapper<NewsUsers> newsUsersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        newsUsersLambdaQueryWrapper.eq(NewsUsers::getUname,userDto.getUname());
        if (getOne(newsUsersLambdaQueryWrapper)!=null) return new ResponseEntity("名称不可重复",HttpStatus.BAD_REQUEST);
        boolean update = updateById(newsUsers);
        if (update) return ResponseEntity.ok("操作成功");
        return new ResponseEntity("更新失败",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity delUser(Integer id, String token) {
        if (loginProperties.getRole(token)!=3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        boolean remove = removeById(id);
        if (remove) return ResponseEntity.ok("操作成功");
        return new ResponseEntity("删除失败",HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity getUserById(Integer id, String token) {
        if (loginProperties.getRole(token) != 3) return new ResponseEntity("权限不足",HttpStatus.BAD_REQUEST);
        NewsUsers user = getById(id);
        UserDto userDto = BeanCopyUtils.copyBean(user, UserDto.class);
        userDto.setRoleName(roleService.getById(user.getRoleid()).getRoleName());
        if (!Objects.isNull(user)) return ResponseEntity.ok("获取成功");
        return new ResponseEntity("获取失败",HttpStatus.BAD_REQUEST);
    }


}

