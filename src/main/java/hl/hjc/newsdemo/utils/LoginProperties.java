package hl.hjc.newsdemo.utils;
import com.alibaba.fastjson.JSON;
import hl.hjc.newsdemo.entity.NewsUsers;
import io.swagger.v3.core.util.Json;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@Component
public class LoginProperties {
    static Properties properties = new Properties();
    static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream("src/main/resources/login.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean getIsLogin(String token){
        return properties.getProperty(token)!=null;
    }
    public Integer getRole(String token){
        String userString = properties.getProperty(token);
        if (Strings.isBlank(userString)) return 2;
        NewsUsers user = JSON.parseObject(userString, NewsUsers.class);
        if (Objects.isNull(user)) return 2;
        return user.getRoleid();
    }

    public void setIsLogin(String token, NewsUsers user){
        if (user == null) properties.remove(token);
        else properties.setProperty(token,JSON.toJSONString(user));
        try {
            properties.store(new FileOutputStream("src/main/resources/login.properties"),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public NewsUsers getUser(String token) {
        String userString = properties.getProperty(token);
        NewsUsers user = JSON.parseObject(userString, NewsUsers.class);
        return user;
    }
}
