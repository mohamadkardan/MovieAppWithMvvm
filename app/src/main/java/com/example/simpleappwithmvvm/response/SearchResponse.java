package com.example.simpleappwithmvvm.response;

import com.example.simpleappwithmvvm.model.Trend;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {
    @SerializedName("page")
    @Expose
    int page;
    @SerializedName("results")
    @Expose
    List<Trend> trends;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Trend> getTrends() {
        return trends;
    }

    public void setTrends(List<Trend> trends) {
        this.trends = trends;
    }
}
