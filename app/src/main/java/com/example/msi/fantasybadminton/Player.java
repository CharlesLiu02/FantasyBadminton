package com.example.msi.fantasybadminton;

import android.graphics.drawable.Drawable;

public class Player {
    private String name;
    private String gender;
    private String nationality;
    private int power;
    private String discipline;
    private String partner;
    private String imageId;
    private boolean ifDrawn;

    public Player(String gender, String nationality, int power, String discipline, String partner, String imageId, String name, boolean ifDrawn) {
        this.gender = gender;
        this.nationality = nationality;
        this.power = power;
        this.discipline = discipline;
        this.partner = partner;
        this.imageId = imageId;
        this.name = name;
        this.ifDrawn = false;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIfDrawn() {
        return ifDrawn;
    }

    public void setIfDrawn(boolean ifDrawn) {
        this.ifDrawn = ifDrawn;
    }
}
