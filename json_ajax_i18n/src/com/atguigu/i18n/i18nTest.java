package com.atguigu.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/12 20:28
 * @Version 1.0
 */
public class i18nTest {
    @Test
    public void testLocale() {

        //get the default language of the system

//        Locale locale = Locale.getDefault();
//        System.out.println(locale);

        // get the china locale

        System.out.println(Locale.CHINA);

        // get the US locale

        System.out.println(Locale.US);
    }

    @Test
    public void testI18n() {
        Locale us = Locale.US;
        Locale china = Locale.CHINA;

        ResourceBundle i18n = ResourceBundle.getBundle("i18n", china);
        String username = i18n.getString("username");
        String password = i18n.getString("password");
        String sex = i18n.getString("sex");
        String age = i18n.getString("age");

        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(age);
    }
}
