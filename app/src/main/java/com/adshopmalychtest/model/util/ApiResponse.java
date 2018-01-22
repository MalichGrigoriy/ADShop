package com.adshopmalychtest.model.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("response")
    @Expose
    private JsonElement response;


    public void setResponse(JsonElement response) {
        this.response = response;
    }

    public JsonElement getResponse() {
        return response;
    }
}
