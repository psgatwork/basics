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
        taskManager.addTask("Test Task 1");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size(), "Task list should contain one task");
        assertEquals("Test Task 1", tasks.get(0).getDescription(), "Task description should match");
        assertFalse(tasks.get(0).isDone(), "New task should not be marked as done");
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
        taskManager.markTaskAsDone("Test Task 1");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertTrue(tasks.get(0).isDone(), "Task should be marked as done");
    }

    @Test
    public void testRemoveTask() {
        taskManager.addTask("Test Task 1");
        taskManager.addTask("Test Task 2");
        taskManager.removeTask("Test Task 1");
        List<TaskManager.Task> tasks = taskManager.listTasks();
        assertEquals(1, tasks.size(), "Task list should contain one task");
        assertEquals("Test Task 2", tasks.get(0).getDescription(), "Remaining task description should match");
    }
}