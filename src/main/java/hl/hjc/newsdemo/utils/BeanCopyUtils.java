package hl.hjc.newsdemo.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : hupo, 创建于:2023/3/13
 */
public class BeanCopyUtils {
    private BeanCopyUtils(){
    }
    public static <V> V copyBean(Object source,Class<V> clazz) {
        //创建目标对象
        V v = null;
        try {
            v = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, v);
        } catch (Exception e) {
            System.out.println("copyBean方法出错");
            e.printStackTrace();
        }
        return v;
    }

    public static <O,V> List<V> copyBeanList(List<O> list,Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
    
}
