package com.example.shaki.newlogin;

public class UplodeImage {
    private String imageDescription;
    private String imageUrl;

    public UplodeImage() {
    }

    public UplodeImage(String imageDescription, String imageUrl) {
        this.imageDescription = imageDescription;
        this.imageUrl = imageUrl;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
