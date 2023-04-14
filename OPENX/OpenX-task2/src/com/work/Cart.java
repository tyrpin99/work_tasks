package com.work;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cart {
    private int id;
    private int userId;
    private Date date;
    private List<OrderProducts> products;

    public Cart(int id, int userId, Date date, List<OrderProducts>products){
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products=products;
    }

    public  List<OrderProducts> getItems() {
        return this.products;
    }

    public int getId(){
        return this.id;
    }
    public int getUserId(){
        return  this.userId;
    }

    public static class OrderProducts{
        private int productId;
        private int quantity;

        public OrderProducts(int productId,int quantity){
            this.productId = productId;
            this.quantity = quantity;
        }
        public int getQuantity(){
            return quantity;
        }
        public int getProductId(){
            return productId;
        }
    }

}
