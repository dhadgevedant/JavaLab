import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reg extends JFrame {

    public reg() {
        setTitle("Student Registration Form");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(new JLabel("Name:"), gbc);
        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(new JLabel("Email:"), gbc);
        JTextField emailField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // PRN Number
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(new JLabel("PRN Number:"), gbc);
        JTextField prnField = new JTextField(20);
        gbc.gridx = 1;
        mainPanel.add(prnField, gbc);

        // Study Year (Radio Buttons)
        gbc.gridx = 0; gbc.gridy++;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(new JLabel("Study Year:"), gbc);
        JPanel radioPanel = new JPanel(new GridLayout(4, 1));
        ButtonGroup yearGroup = new ButtonGroup();
        JRadioButton fy = new JRadioButton("FY");
        JRadioButton sy = new JRadioButton("SY");
        JRadioButton ty = new JRadioButton("TY");
        JRadioButton btech = new JRadioButton("BTech");
        yearGroup.add(fy); yearGroup.add(sy); yearGroup.add(ty); yearGroup.add(btech);
        radioPanel.add(fy); radioPanel.add(sy); radioPanel.add(ty); radioPanel.add(btech);
        gbc.gridx = 1;
        mainPanel.add(radioPanel, gbc);
        gbc.anchor = GridBagConstraints.CENTER;

        // Hometown (ComboBox)
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(new JLabel("Hometown:"), gbc);
        String[] towns = {"Nagar", "Pune", "Kopargaon", "Mumbai", "Nashik", "Other"};
        JComboBox<String> hometownBox = new JComboBox<>(towns);
        gbc.gridx = 1;
        mainPanel.add(hometownBox, gbc);

        // Programming Languages (Checkboxes)
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        mainPanel.add(new JLabel("Languages Known:"), gbc);

        gbc.gridy++;
        JPanel langPanel = new JPanel(new GridLayout(3, 2));
        JCheckBox javaCB = new JCheckBox("Java");
        JCheckBox pythonCB = new JCheckBox("Python");
        JCheckBox cppCB = new JCheckBox("C++");
        JCheckBox jsCB = new JCheckBox("JavaScript");
        JCheckBox htmlCB = new JCheckBox("HTML/CSS");
        JCheckBox otherCB = new JCheckBox("Other");
        langPanel.add(javaCB);
        langPanel.add(pythonCB);
        langPanel.add(cppCB);
        langPanel.add(jsCB);
        langPanel.add(htmlCB);
        langPanel.add(otherCB);
        mainPanel.add(langPanel, gbc);

        // Submit Button
        gbc.gridy++;
        JButton submitButton = new JButton("Submit");
        mainPanel.add(submitButton, gbc);

        // Submit Action
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String prn = prnField.getText();
                String year = "";
                if (fy.isSelected()) year = "FY";
                else if (sy.isSelected()) year = "SY";
                else if (ty.isSelected()) year = "TY";
                else if (btech.isSelected()) year = "BTech";

                String hometown = (String) hometownBox.getSelectedItem();

                StringBuilder langs = new StringBuilder();
                if (javaCB.isSelected()) langs.append("Java, ");
                if (pythonCB.isSelected()) langs.append("Python, ");
                if (cppCB.isSelected()) langs.append("C++, ");
                if (jsCB.isSelected()) langs.append("JavaScript, ");
                if (htmlCB.isSelected()) langs.append("HTML/CSS, ");
                if (otherCB.isSelected()) langs.append("Other, ");
                if (langs.length() > 0)
                    langs.setLength(langs.length() - 2); // Remove last comma and space

                JOptionPane.showMessageDialog(reg.this,
                    "Registered:\nName: " + name + "\nEmail: " + email +
                    "\nPRN: " + prn + "\nYear: " + year + "\nHometown: " + hometown +
                    "\nLanguages Known: " + langs,
                    "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new reg());
    }
}
