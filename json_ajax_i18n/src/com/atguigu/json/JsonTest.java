package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/10 21:31
 * @Version 1.0
 */
public class JsonTest {

    /**
     * 1.java bean and json exchange
     */
    @Test
    public void test1() {
        Person person = new Person(1, "abc");
        Gson gson = new Gson();

        String json = gson.toJson(person);

        System.out.println(json);

        Person person1 = gson.fromJson(json, Person.class);

        System.out.println(person1);

    }

    /**
     * List and json exchange
     */
    @Test
    public void test2() {
        List<Person> list = new ArrayList<>();

        list.add(new Person(1, "abc"));
        list.add(new Person(2, "def"));

        Gson gson = new Gson();

        String json = gson.toJson(list);
        System.out.println(json);

       List<Person> list1 = gson.fromJson(json, new PersonListType().getType());

        System.out.println(list1);
    }

    /**
     * map and json exchange
     */
    @Test
    public void test3() {
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person(1, "abc"));
        map.put(2, new Person(2, "def"));

        Gson gson = new Gson();
        String json = gson.toJson(map);

        System.out.println(json);

//        Object o = gson.fromJson(json, new PersonMapType().getType());


        Object o = gson.fromJson(json, new TypeToken<Map<Integer, Person>>() {
        }.getType());
        System.out.println(o);
        Map<Integer, Person> map1 = (Map<Integer, Person>) o;

        System.out.println(map1.get(2));
    }
}
