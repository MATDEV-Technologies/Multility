package com.matdevtech.multility.models;

// Imports
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

// Main class
public class News {
  // Initialization and get/set functionality for the 'News' component of News
  @SerializedName("status")
  @Expose
  private String status;

  @SerializedName("totalResult")
  @Expose
  private int totalResult;

  @SerializedName("articles")
  @Expose
  private List<Article> article;

  @SuppressWarnings("unused")
  public String getStatus() { return status; }

  @SuppressWarnings("unused")
  public void setStatus(String status) { this.status = status; }

  @SuppressWarnings("unused")
  public int getTotalResult() { return totalResult; }

  @SuppressWarnings("unused")
  public void setTotalResult(int totalResult) { this.totalResult = totalResult; }

  public List<Article> getArticle() { return article; }

  @SuppressWarnings("unused")
  public void setArticle(List<Article> article) { this.article = article; }
}