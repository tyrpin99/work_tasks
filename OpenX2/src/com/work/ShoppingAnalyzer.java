package com.work;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ShoppingAnalyzer {

    private static final String USERS_URL = "https://fakestoreapi.com/users";
    private static final String CARTS_URL = "https://fakestoreapi.com/carts";
    private static final String PRODUCTS_URL = "https://fakestoreapi.com/products";
    public static final double RADIUS_OF_EARTH_KM = 6371.01;

    private List<User> users;
    private List<Cart> carts;
    private List<Product> products;

    public void loadData() throws IOException {
        Gson gson = new Gson();
        users = getDataFromUrl(USERS_URL, gson, new TypeToken<List<User>>(){}.getType());
        carts = getDataFromUrl(CARTS_URL, gson, new TypeToken<List<Cart>>(){}.getType());
        products = getDataFromUrl(PRODUCTS_URL, gson, new TypeToken<List<Product>>(){}.getType());
    }

    public Map<String, Double> getCategoriesValue() {
        Map<String, Double> categoriesValue = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            Double value = categoriesValue.getOrDefault(category, 0.0);
            categoriesValue.put(category, value + product.getPrice());
        }
        return categoriesValue;
    }

    public Cart getCartWithHighestValue() {
        Cart cartWithHighestValue = null;
        double highestValue = 0;
        for (Cart cart : carts) {
            double cartValue = 0;
            for (Cart.OrderProducts item : cart.getItems()) {
                Product product = getProductById(item.getProductId());
                if (product != null) {
                    cartValue += product.getPrice() * item.getQuantity();
                }
            }
            if (cartValue > highestValue) {
                highestValue = cartValue;
                cartWithHighestValue = cart;
            }
        }
        return cartWithHighestValue;
    }


    public List<Integer> getUsersWithGreatestDistance() {
        List<Integer> usersWithGreatestDistance = new ArrayList<>();
        double greatestDistance = 0;
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                User user1 = users.get(i);
                User user2 = users.get(j);
                double distance = calculateDistance(user1.getAddress().getGeo().getLat(),user1.getAddress().getGeo().getLong(), user2.getAddress().getGeo().getLat(),user2.getAddress().getGeo().getLong());
                if (distance > greatestDistance) {
                    greatestDistance = distance;
                    usersWithGreatestDistance.clear();
                    usersWithGreatestDistance.add(user1.getId());
                    usersWithGreatestDistance.add(user2.getId());
                } else if (distance == greatestDistance) {
                    usersWithGreatestDistance.add(user1.getId());
                    usersWithGreatestDistance.add(user2.getId());
                }
            }
        }
        return usersWithGreatestDistance;
    }

    private Product getProductById(long id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.pow(Math.sin(deltaLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RADIUS_OF_EARTH_KM * c;
    }
    private <T> T getDataFromUrl(String urlString, Gson gson, Type type) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        String response = scanner.useDelimiter("\\A").next();
        scanner.close();

        return gson.fromJson(response, type);
    }
}



