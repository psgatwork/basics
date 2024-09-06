package com.learning.copilot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testTaskManagerInitialization() {
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertNotNull(tasks, "Task list should not be null");
        assertTrue(tasks.isEmpty(), "Task list should be empty upon initialization");
    }

    @Test
    public void testAddTask() {
        boolean added = taskManager.addTask("Test Task 1");
        assertTrue(added, "Task should be added successfully");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size(), "Task list should contain one task");
        assertEquals("Test Task 1", tasks.get(0).getDescription(), "Task description should match");
        assertFalse(tasks.get(0).isDone(), "New task should not be marked as done");
    }

    @Test
    public void testAddDuplicateTask() {
        taskManager.addTask("Test Task 1");
        boolean added = taskManager.addTask("Test Task 1");
        assertFalse(added, "Duplicate task should not be added");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size(), "Task list should contain one task");
    }

    @Test
    public void testListTasks() {
        taskManager.addTask("Test Task 1");
        taskManager.addTask("Test Task 2");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(2, tasks.size(), "Task list should contain two tasks");
        assertEquals("Test Task 1", tasks.get(0).getDescription(), "First task description should match");
        assertEquals("Test Task 2", tasks.get(1).getDescription(), "Second task description should match");
    }

    @Test
    public void testMarkTaskAsDone() {
        taskManager.addTask("Test Task 1");
        boolean marked = taskManager.markTaskAsDone("Test Task 1");
        assertTrue(marked, "Task should be marked as done successfully");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertTrue(tasks.get(0).isDone(), "Task should be marked as done");
    }

    @Test
    public void testMarkNonExistentTaskAsDone() {
        boolean marked = taskManager.markTaskAsDone("Non-existent Task");
        assertFalse(marked, "Non-existent task should not be marked as done");
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Test Task 1");
        taskManager.addTask("Test Task 2");
        boolean removed = taskManager.removeTask("Test Task 1");
        assertTrue(removed, "Task should be removed successfully");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size(), "Task list should contain one task");
        assertEquals("Test Task 2", tasks.get(0).getDescription(), "Remaining task description should match");
    }

    @Test
    public void testRemoveNonExistentTask() {
        boolean removed = taskManager.removeTask("Non-existent Task");
        assertFalse(removed, "Non-existent task should not be removed");
    }
}