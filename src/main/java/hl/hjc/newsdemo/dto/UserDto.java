package hl.hjc.newsdemo.dto;

import hl.hjc.newsdemo.entity.NewsUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer uid;
    private String uname;
    private String upwd;
    private Integer roleid;
    private String roleName;
}
