package com.work;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ShoppingAnalyzer shoppingAnalyzer = new ShoppingAnalyzer();
        try {
            shoppingAnalyzer.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Cart with highest value id: "+ shoppingAnalyzer.getCartWithHighestValue().getId());
        System.out.println("Users living furthers away from each other: " +shoppingAnalyzer.getUsersWithGreatestDistance());
        System.out.println("Categories value: "+ shoppingAnalyzer.getCategoriesValue());
    }
}
