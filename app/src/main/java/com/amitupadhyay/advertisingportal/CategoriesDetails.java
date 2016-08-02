package com.amitupadhyay.advertisingportal;

/**
 * Created by aupadhyay on 8/2/16.
 */

public class CategoriesDetails {

    private String details;
    private int image;

    public CategoriesDetails(String details, int image) {
        this.details = details;
        this.image = image;
    }

    public CategoriesDetails() {
    }

    public String getDetails() {
        return details;
    }

    public int getImage() {
        return image;
    }
}
