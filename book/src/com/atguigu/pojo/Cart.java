package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @Description 购物车对象
 * @Author hliu
 * @Date 2023/4/4 17:21
 * @Version 1.0
 */
public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            CartItem value = entry.getValue();
            totalCount += value.getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            CartItem value = entry.getValue();
            totalPrice = totalPrice.add(value.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
    * @Description: add item to cart
    * @Param: [cartItem]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/4
    */
    public void addItem(CartItem cartItem) {
        // check item if exist
        CartItem item = items.get(cartItem.getId());

        if (item == null) {
            items.put(cartItem.getId(), cartItem);
        } else {
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
    * @Description: delete item from cart
    * @Param: [cartItem]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/4
    */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
    * @Description: clear all items in cart
    * @Param: []
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/5
    */
    public void clear() {
        items.clear();
    }

    /**
    * @Description: update the count of item in the cart
    * @Param: [id, count]
    * @return: void
    * @Author: hliu
    * @Date: 2023/4/5
    */
    public void updateCount(Integer id, Integer count) {
        //check if exists
        CartItem item = items.get(id);

        if (item != null) {
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
}
