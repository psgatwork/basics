package com.learning.copilot;

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a Task Manager that manages a list of tasks.
 */
public class TaskManager {

    /**
     * List of tasks managed by the Task Manager.
     */
    private List<Task> tasks;

    /**
     * Constructs a new TaskManager object.
     * Initializes the tasks list as an empty ArrayList.
     */
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the task list.
     *
     * @param description The description of the task to be added.
     */
    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    /**
     * Returns the list of tasks managed by the Task Manager.
     *
     * @return The list of tasks.
     */
    public List<Task> listTasks() {
        return tasks;
    }

    /**
     * Marks a task as done based on its description.
     * If a task with the given description is found, its 'done' status is set to true.
     *
     * @param description The description of the task to be marked as done.
     */
    public void markTaskAsDone(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                task.setDone(true);
                break;
            }
        }
    }

    /**
     * Removes a task from the task manager based on its description.
     *
     * @param description the description of the task to be removed
     */
    public void removeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                tasks.remove(task);
                break;
            }
        }
    }

    /**
     * Represents a task with a description and a 'done' status.
     */
    public class Task {
        /**
         * The description of the task.
         */
        private String description;

        /**
         * The status of the task (true if done, false otherwise).
         */
        private boolean done;

        /**
         * Constructs a new Task object with the given description.
         * The initial 'done' status is set to false.
         *
         * @param description The description of the task.
         */
        public Task(String description) {
            this.description = description;
            this.done = false;
        }

        /**
         * Returns the description of the task.
         *
         * @return The description of the task.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Returns the status of the task.
         *
         * @return The status of the task (true if done, false otherwise).
         */
        public boolean isDone() {
            return done;
        }

        /**
         * Sets the status of the task.
         *
         * @param done The status of the task (true if done, false otherwise).
         */
        public void setDone(boolean done) {
            this.done = done;
        }
    }

}