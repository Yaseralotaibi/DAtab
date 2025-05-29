
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AppointmentManager extends JFrame {
    private JTextField txtID, txtDate, txtTime, txtReason, txtStatus;
    private JTextArea displayArea;
    private ArrayList<String> appointments = new ArrayList<>();

    public AppointmentManager() {
        setTitle("Appointment Manager");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        txtID = new JTextField();
        txtDate = new JTextField();
        txtTime = new JTextField();
        txtReason = new JTextField();
        txtStatus = new JTextField();

        inputPanel.add(new JLabel("Appointment ID:"));
        inputPanel.add(txtID);
        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        inputPanel.add(txtDate);
        inputPanel.add(new JLabel("Time (HH:MM):"));
        inputPanel.add(txtTime);
        inputPanel.add(new JLabel("Reason:"));
        inputPanel.add(txtReason);
        inputPanel.add(new JLabel("Status:"));
        inputPanel.add(txtStatus);

        JButton addButton = new JButton("Add Appointment");
        addButton.addActionListener(e -> addAppointment());
        inputPanel.add(addButton);

        JButton viewButton = new JButton("View All");
        viewButton.addActionListener(e -> viewAppointments());
        inputPanel.add(viewButton);

        displayArea = new JTextArea();
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addAppointment() {
        String entry = "ID: " + txtID.getText() + ", Date: " + txtDate.getText()
                + ", Time: " + txtTime.getText() + ", Reason: " + txtReason.getText()
                + ", Status: " + txtStatus.getText();
        appointments.add(entry);
        clearFields();
    }

    private void viewAppointments() {
        displayArea.setText("");
        for (String app : appointments) {
            displayArea.append(app + "\n");
        }
    }

    private void clearFields() {
        txtID.setText("");
        txtDate.setText("");
        txtTime.setText("");
        txtReason.setText("");
        txtStatus.setText("");
    }

    public static void main(String[] args) {
        new AppointmentManager();
    }
}
