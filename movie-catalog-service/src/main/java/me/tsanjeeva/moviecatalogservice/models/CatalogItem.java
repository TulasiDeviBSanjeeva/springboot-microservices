package me.tsanjeeva.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private String desc;
    private int rating;
    private String tagline;

    public CatalogItem(String name, String desc, String tagline, int rating) {
        this.name = name;
        this.desc = desc;
        this.tagline = tagline;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}

