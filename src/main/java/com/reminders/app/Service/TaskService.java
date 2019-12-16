package com.reminders.app.Service;

import com.reminders.app.model.Task;
import com.sun.media.jfxmedia.logging.Logger;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class TaskService {
    private HashMap<Integer, Task> taskList;
    private static TaskService taskServiceInstance = null;

    public static TaskService getInstance() {
        if (taskServiceInstance == null)
            taskServiceInstance = new TaskService();
        return taskServiceInstance;
    }

    private TaskService() {
        taskList = new HashMap<>();
    }

    public Collection getTasks() {
        LOGGER.info("Getting Tasks");
        return taskList.values();
    }

    public void addTask(Task task) {
        task.setId(taskList.size()+1);
        //task.setStatus("Not Completed");
        taskList.put(taskList.size()+1, task);
        LOGGER.info("Created New Task");
    }

    public void editTask(Task task) {
        Task tempTask = taskList.get(task.getId());
        tempTask.setStatus(task.getStatus());
        tempTask.setPriority(task.getPriority());
        tempTask.setTask(task.getTask());
        taskList.put(task.getId(), tempTask);
        LOGGER.info("Edited Task");
    }

    public void deleteTask(Task task) {
        taskList.remove(task.getId());
    }
}
