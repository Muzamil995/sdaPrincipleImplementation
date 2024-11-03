package ModelLayer;

public class Task {
    private int id;
    private String description;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String description, boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id (optional if the id is auto-generated by the database)
    public void setId(int id) {
        this.id = id;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for isCompleted
    public boolean isCompleted() {
        return isCompleted;
    }

    // Setter for isCompleted
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
