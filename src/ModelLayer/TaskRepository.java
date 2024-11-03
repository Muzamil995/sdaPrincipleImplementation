package ModelLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private DatabaseHelper dbHelper = DatabaseHelper.getInstance();

    public void addTask(Task task) {
        try (Connection conn = dbHelper.connect();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO tasks (description, isCompleted) VALUES (?, ?)")) {
            stmt.setString(1, task.getDescription());
            stmt.setBoolean(2, task.isCompleted());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = dbHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {
            while (rs.next()) {
                tasks.add(new Task(rs.getInt("id"), rs.getString("description"), rs.getBoolean("isCompleted")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    // Add methods for update and delete as needed
}
