package com.nask.naskrekrutacja.models;

import java.util.ArrayList;
import java.util.List;

public class People
{
    public Integer id;
    public String name;
    public String height;
    public String mass;
    public String hairColor;
    public String skinColor;
    public String eyeColor;
    public String birthYear;
    public String gender;
    public Homeworld homeworld;
    public List<Starship> starships;

    public People()
    {
        this.starships=new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Homeworld getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(Homeworld homeworld) {
        this.homeworld = homeworld;
    }

    public List<Starship> getStarships() {
        return starships;
    }

    public void setStarships(List<Starship> starships) {
        this.starships = starships;
    }
    public void setStarships(Starship starship) {
        this.starships.add(starship);
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof People)) return false;
        if(this.id!=((People) obj).getId()) return false;
        return true;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}