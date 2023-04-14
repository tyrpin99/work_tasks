package com.work;

import java.util.Map;

public class User {
    private int id;
    private Map<String, String> name;
    private String username;
    private String email;
    private UserAddress address;
    private String phone;


    public UserAddress getAddress(){
        return address;
    }

    public int getId() {
        return id;
    }
}
class UserAddress{
    private Geolocation geolocation;
    private String city;
    private String street;
    private int number;
    private String zipcode;

    public Geolocation getGeo(){
        return geolocation ;
    }


}
class Geolocation{
    private double lat;
    private double long1;

    public double getLat() {
        return lat;
    }

    public double getLong() {
        return long1;
    }


}
