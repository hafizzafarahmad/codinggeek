package com.princedev.coddinggeek.Model;

public class User {

    private String id;
    private String email;
    private String name;
    private String password;
    private String genre;
    private String country;
    private String occupation;
    private String bod;

    public User() {
    }

    public User(String id, String email, String name, String password, String genre, String country, String occupation, String bod) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.genre = genre;
        this.country = country;
        this.occupation = occupation;
        this.bod = bod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }
}
