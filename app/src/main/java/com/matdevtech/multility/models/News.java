package com.matdevtech.multility.models;

// Imports
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

// Main class
public class News {
  // Init News attributes
  @SerializedName("status")
  @Expose
  private String status;

  @SerializedName("totalResult")
  @Expose
  private int totalResult;

  @SerializedName("articles")
  @Expose
  private List<Article> article;

  @SuppressWarnings({"unused", "RedundantSuppression"})
  public String getStatus() { return status; }

  @SuppressWarnings({"unused", "RedundantSuppression"})
  public void setStatus(String status) { this.status = status; }

  @SuppressWarnings({"unused", "RedundantSuppression"})
  public int getTotalResult() { return totalResult; }

  @SuppressWarnings({"unused", "RedundantSuppression"})
  public void setTotalResult(int totalResult) { this.totalResult = totalResult; }

  public List<Article> getArticle() { return article; }

  @SuppressWarnings({"unused", "RedundantSuppression"})
  public void setArticle(List<Article> article) { this.article = article; }
}