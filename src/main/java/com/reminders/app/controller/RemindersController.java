package com.reminders.app.controller;

import com.google.gson.Gson;
import com.reminders.app.Service.TaskService;
import com.reminders.app.model.Task;
import com.reminders.app.response.StandardResponse;

import static spark.Spark.*;

public class RemindersController {
    private RemindersController() {}

    public static void init() {
        final TaskService taskService = TaskService.getInstance();

        get("/tasks", (req, res) -> {
            if(taskService.getTasks().isEmpty()) {
                return new Gson().toJson(new StandardResponse("List Empty"));
            }
            return new Gson().toJson(new StandardResponse(new Gson().toJsonTree(taskService.getTasks())));
        });
        post("/tasks", (req, res) -> {
            Task task = new Gson().fromJson(req.body(), Task.class);
            taskService.addTask(task);
            return new Gson().toJson(new StandardResponse("Added Successfully"));
        });
        put("/editTask", (req, res) -> {
            Task task = new Gson().fromJson(req.body(), Task.class);
            taskService.editTask(task);
            return new Gson().toJson(new StandardResponse("Edit Successful"));
        });
        delete("/deleteTask", (req, res) -> {
            Task task = new Gson().fromJson(req.body(), Task.class);
            taskService.deleteTask(task);
            return new Gson().toJson(new StandardResponse("Deleted Task"));
        });
    }
}
