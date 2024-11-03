package ViewLayer;

import ControllerLayer.TaskController;
import ModelLayer.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskView {
    private final TaskController taskController;
    private JFrame frame;
    private JTextField descriptionField;
    private JCheckBox isCompletedCheckBox;

    public TaskView() {
        taskController = new TaskController();
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("To-Do App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Description Label and Field
        JLabel descriptionLabel = new JLabel("Task Description:");
        descriptionField = new JTextField();

        // Completed Checkbox
        JLabel isCompletedLabel = new JLabel("Is Completed:");
        isCompletedCheckBox = new JCheckBox();

        // Add Button
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // Add Components to Frame
        frame.add(descriptionLabel);
        frame.add(descriptionField);
        frame.add(isCompletedLabel);
        frame.add(isCompletedCheckBox);
        frame.add(addButton);

        frame.setVisible(true);
    }

    private void addTask() {
        String description = descriptionField.getText();
        boolean isCompleted = isCompletedCheckBox.isSelected();

        // Create a new Task object
        Task task = new Task(0, description, isCompleted);

        // Pass the task to the controller to save it
        taskController.addTask(task);

        JOptionPane.showMessageDialog(frame, "Task has been saved to the database.");
        // Clear input fields
        descriptionField.setText("");
        isCompletedCheckBox.setSelected(false);
    }
}
