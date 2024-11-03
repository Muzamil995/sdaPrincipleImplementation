package ModelLayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:todoapp.db";

    // Singleton pattern to ensure only one instance
    private static DatabaseHelper instance;

    private DatabaseHelper() {
        createTasksTable();
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    private void createTasksTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                description TEXT NOT NULL,
                isCompleted BOOLEAN NOT NULL
            );
            """;
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error creating tasks table: " + e.getMessage());
        }
    }
}
