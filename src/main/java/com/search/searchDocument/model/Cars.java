package com.search.searchDocument.model;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Elastic Search Model used for searching the indexed files
 */
@Document(indexName = "cars")
public class Cars {
    private String id;
    private String maker;
    private String model;
    private int mileage;
    private String manufacture_year;
    private String engine_displacement;
    private String body_type;
    private String color_slug;
    private String stk_year;
    private String transmission;
    private String fuel_type;
    private String date_created;
    private String date_last_seen;
    private float price_eur;
    private int engine_power;
    private int door_count;
    private int seat_count;

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(String manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public String getEngine_displacement() {
        return engine_displacement;
    }

    public void setEngine_displacement(String engine_displacement) {
        this.engine_displacement = engine_displacement;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getColor_slug() {
        return color_slug;
    }

    public void setColor_slug(String color_slug) {
        this.color_slug = color_slug;
    }

    public String getStk_year() {
        return stk_year;
    }

    public void setStk_year(String stk_year) {
        this.stk_year = stk_year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_last_seen() {
        return date_last_seen;
    }

    public void setDate_last_seen(String date_last_seen) {
        this.date_last_seen = date_last_seen;
    }

    public float getPrice_eur() {
        return price_eur;
    }

    public void setPrice_eur(float price_eur) {
        this.price_eur = price_eur;
    }

    public int getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(int engine_power) {
        this.engine_power = engine_power;
    }

    public int getDoor_count() {
        return door_count;
    }

    public void setDoor_count(int door_count) {
        this.door_count = door_count;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
