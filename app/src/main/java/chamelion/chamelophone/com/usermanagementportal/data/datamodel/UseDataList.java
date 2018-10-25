package chamelion.chamelophone.com.usermanagementportal.data.datamodel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UseDataList {

  @SerializedName("page")
  @Expose
  private int page;
  @SerializedName("per_page")
  @Expose
  private int perPage;
  @SerializedName("total")
  @Expose
  private int total;
  @SerializedName("total_pages")
  @Expose
  private int totalPages;
  @SerializedName("data")
  @Expose
  private List<Data> data = null;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public UseDataList withPage(int page) {
    this.page = page;
    return this;
  }

  public int getPerPage() {
    return perPage;
  }

  public void setPerPage(int perPage) {
    this.perPage = perPage;
  }

  public UseDataList withPerPage(int perPage) {
    this.perPage = perPage;
    return this;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public UseDataList withTotal(int total) {
    this.total = total;
    return this;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public UseDataList withTotalPages(int totalPages) {
    this.totalPages = totalPages;
    return this;
  }

  public List<Data> getData() {
    return data;
  }

  public void setData(List<Data> data) {
    this.data = data;
  }

  public UseDataList withData(List<Data> data) {
    this.data = data;
    return this;
  }

}