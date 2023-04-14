package com.work;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ShoppingAnalyzerTest {
    private ShoppingAnalyzer shoppingAnalyzer;

    @BeforeEach
    public void setUp() {
        shoppingAnalyzer = new ShoppingAnalyzer();
        try {
            shoppingAnalyzer.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCartWithHighestValue() {
        Cart cartWithHighestValue = shoppingAnalyzer.getCartWithHighestValue();
        Assertions.assertEquals(2, cartWithHighestValue.getId());
    }

    @Test
    public void testGetUsersWithGreatestDistance() {
        List<Integer> usersWithGreatestDistance = shoppingAnalyzer.getUsersWithGreatestDistance();
        Assertions.assertEquals("[1, 4, 2, 4]", usersWithGreatestDistance.toString());
    }

    @Test
    public void testGetCategoriesValue() {
        Map<String, Double> categoriesValue = shoppingAnalyzer.getCategoriesValue();
        Assertions.assertEquals("{electronics=1994.99, women's clothing=157.72, men's clothing=204.23000000000002, jewelery=883.98}", categoriesValue.toString());
    }
}
