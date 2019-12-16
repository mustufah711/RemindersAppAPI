package com.reminders.app.response;

import com.google.gson.JsonElement;

public class StandardResponse {
    private String responseStatus;
    private String message;
    private JsonElement users;
    private JsonElement tasks;

    public StandardResponse(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public StandardResponse(String responseStatus, String message) {
        this.responseStatus = responseStatus;
        this.message = message;
    }

    public StandardResponse(String responseStatus, JsonElement users) {
        this.responseStatus = responseStatus;
        this.users = users;
    }

    public StandardResponse(JsonElement tasks) {
        this.tasks = tasks;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonElement getUserData() {
        return users;
    }

    public void setUserData(JsonElement userData) {
        this.users = userData;
    }
}
