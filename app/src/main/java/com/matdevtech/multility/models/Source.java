package com.matdevtech.multility.models;

// Imports
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Main Class
public class Source {
    // Initialization and get/set functionality for the 'Source' component of News
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    public String getId() {
        return id;
    }

    public void setId(@SuppressWarnings("unused") String name) {
        //noinspection SillyAssignment
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
