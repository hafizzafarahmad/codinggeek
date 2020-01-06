package com.princedev.coddinggeek.Model;

public class Language {

    private String language_id;
    private String name;
    private String image;

    public Language() {
    }

    public Language(String language_id, String name, String image) {
        this.language_id = language_id;
        this.name = name;
        this.image = image;
    }

    public String getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(String language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
