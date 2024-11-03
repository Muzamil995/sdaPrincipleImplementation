package ControllerLayer;

import ModelLayer.DatabaseHelper;
import ModelLayer.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskController {
    private final DatabaseHelper dbHelper;

    public TaskController() {
        dbHelper = DatabaseHelper.getInstance();
    }

    public void addTask(Task task) {
        String sql = "INSERT INTO tasks (description, isCompleted) VALUES (?, ?)";

        try (Connection conn = dbHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, task.getDescription());
            pstmt.setBoolean(2, task.isCompleted());
            pstmt.executeUpdate();
            System.out.println("Task added successfully.");

        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }
}
