package com.matdevtech.multility.models;

// Imports
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// Main class
public class Article {
    // Init Article attributes
    @SerializedName("source")
    @Expose
    private Source source;

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;

    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    public Source getSource() { return source; }

    @SuppressWarnings("unused")
    public void setSource(Source source) { this.source = source; }

    public String getAuthor() { return author;}

    @SuppressWarnings("unused")
    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }

    @SuppressWarnings("unused")
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    @SuppressWarnings("unused")
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }

    @SuppressWarnings("unused")
    public void setUrl(String url) { this.url = url; }

    public String getUrlToImage() { return urlToImage; }

    @SuppressWarnings("unused")
    public void setUrlToImage(String urlToImage) { this.urlToImage = urlToImage; }

    public String getPublishedAt() { return publishedAt; }

    @SuppressWarnings("unused")
    public void setPublishedAt(String publishedAt) { this.publishedAt = publishedAt; }
}
