package com.testing.graphs;

/**
 * Created by Mariusz on 2014-06-28.
 */
public class PointGraphJavaObject {
    private String day;
    private String price;
    private String rise;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRise() {
        return rise;
    }

    public void setRise(String rise) {
        this.rise = rise;
    }


    @Override
    public String toString() {
        return "PointGraphJavaOBject{" +
                "day='" + day + '\'' +
                ", price='" + price + '\'' +
                ", rise='" + rise + '\'' +
                '}';
    }

}
