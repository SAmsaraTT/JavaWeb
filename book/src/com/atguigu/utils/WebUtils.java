package com.atguigu.utils;

import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/28 16:21
 * @Version 1.0
 */
public class WebUtils {

    /**
    * @Description: 注入属性值
    * @Param: [map, bean]
    * @return: void
    * @Author: hliu
    * @Date: 2023/3/28
    */
    public static <T> T copyParamToBean(Map map, T bean) {
        try {
            System.out.println("before: " + bean);
            BeanUtils.populate(bean, map);
            System.out.println("after: " + bean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return bean;
    }
}
