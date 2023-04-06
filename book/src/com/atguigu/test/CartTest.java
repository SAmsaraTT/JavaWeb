package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author hliu
 * @Date 2023/4/5 14:58
 * @Version 1.0
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "ds and algo", 1, new BigDecimal(100), new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "ds and algo", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "ds and algo", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(1);
        cart.clear();

        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "ds and algo", 1, new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(1);

        cart.clear();

        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.updateCount(1, 10);

        System.out.println(cart);
    }
}