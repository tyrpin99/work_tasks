package com.work;

public class Product {
    private long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;
    private Rating rating;

    public String getCategory() {
        return this.category;
    }
    public double getPrice() {
        return this.price;
    }
    public long getProductId() {
        return this.id;
    }

}
class Rating{
    double rate;
    int count;
}