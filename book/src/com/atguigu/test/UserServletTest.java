package com.atguigu.test;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author hliu
 * @Date 2023/3/28 12:04
 * @Version 1.0
 */
public class UserServletTest {
    public void login() {
        System.out.println("login方法！");
    }

    public void regist() {
        System.out.println("regist方法！");
    }

    public void updateUser() {
        System.out.println("updateUser方法！");
    }

    public void updateUserPassword() {
        System.out.println("updateUserPassword方法！");
    }

    @Test
    public void test() {
        String action = "updateUser";

        try {
            Method declaredMethod = UserServletTest.class.getDeclaredMethod(action);

            System.out.println(declaredMethod);

            declaredMethod.invoke(new UserServletTest());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
