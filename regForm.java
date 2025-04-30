import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reg extends JFrame {

    public reg() {
        setTitle("Student Registration Form");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set dark minimalist theme
        UIManager.put("Panel.background", new Color(30, 30, 30));
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("TextField.background", new Color(50, 50, 50));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("TextField.caretForeground", Color.WHITE);
        UIManager.put("ComboBox.background", new Color(50, 50, 50));
        UIManager.put("ComboBox.foreground", Color.WHITE);
        UIManager.put("CheckBox.background", new Color(30, 30, 30));
        UIManager.put("CheckBox.foreground", Color.WHITE);
        UIManager.put("RadioButton.background", new Color(30, 30, 30));
        UIManager.put("RadioButton.foreground", Color.WHITE);
        UIManager.put("Button.background", new Color(70, 70, 70));
        UIManager.put("Button.foreground", Color.WHITE);

        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Name
        gbc.gridx = 0; gbc.gridy = 0;
        mainPanel.add(createLabel("Name:", font), gbc);
        JTextField nameField = createTextField(font);
        gbc.gridx = 1;
        mainPanel.add(nameField, gbc);

        // Email
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(createLabel("Email:", font), gbc);
        JTextField emailField = createTextField(font);
        gbc.gridx = 1;
        mainPanel.add(emailField, gbc);

        // PRN Number
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(createLabel("PRN Number:", font), gbc);
        JTextField prnField = createTextField(font);
        gbc.gridx = 1;
        mainPanel.add(prnField, gbc);

        // Study Year
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(createLabel("Study Year:", font), gbc);
        JPanel radioPanel = new JPanel(new GridLayout(4, 1));
        radioPanel.setBackground(new Color(30, 30, 30));
        ButtonGroup yearGroup = new ButtonGroup();
        JRadioButton fy = createRadioButton("FY", font);
        JRadioButton sy = createRadioButton("SY", font);
        JRadioButton ty = createRadioButton("TY", font);
        JRadioButton btech = createRadioButton("BTech", font);
        yearGroup.add(fy); yearGroup.add(sy); yearGroup.add(ty); yearGroup.add(btech);
        radioPanel.add(fy); radioPanel.add(sy); radioPanel.add(ty); radioPanel.add(btech);
        gbc.gridx = 1;
        mainPanel.add(radioPanel, gbc);

        // Hometown
        gbc.gridx = 0; gbc.gridy++;
        mainPanel.add(createLabel("Hometown:", font), gbc);
        String[] towns = {"Nagar", "Pune", "Kopargaon", "Mumbai", "Nashik", "Other"};
        JComboBox<String> hometownBox = new JComboBox<>(towns);
        hometownBox.setFont(font);
        gbc.gridx = 1;
        mainPanel.add(hometownBox, gbc);

        // Programming Languages
        gbc.gridx = 0; gbc.gridy++;
        gbc.gridwidth = 2;
        mainPanel.add(createLabel("Languages Known:", font), gbc);

        gbc.gridy++;
        JPanel langPanel = new JPanel(new GridLayout(3, 2));
        langPanel.setBackground(new Color(30, 30, 30));
        JCheckBox javaCB = createCheckBox("Java", font);
        JCheckBox pythonCB = createCheckBox("Python", font);
        JCheckBox cppCB = createCheckBox("C++", font);
        JCheckBox jsCB = createCheckBox("JavaScript", font);
        JCheckBox htmlCB = createCheckBox("HTML/CSS", font);
        JCheckBox otherCB = createCheckBox("Other", font);
        langPanel.add(javaCB); langPanel.add(pythonCB);
        langPanel.add(cppCB); langPanel.add(jsCB);
        langPanel.add(htmlCB); langPanel.add(otherCB);
        mainPanel.add(langPanel, gbc);

        // Submit Button
        gbc.gridy++;
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(font);
        mainPanel.add(submitButton, gbc);

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
                    langs.setLength(langs.length() - 2);

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

    private JLabel createLabel(String text, Font font) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    private JTextField createTextField(Font font) {
        JTextField tf = new JTextField(20);
        tf.setFont(font);
        tf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        return tf;
    }

    private JRadioButton createRadioButton(String text, Font font) {
        JRadioButton rb = new JRadioButton(text);
        rb.setFont(font);
        return rb;
    }

    private JCheckBox createCheckBox(String text, Font font) {
        JCheckBox cb = new JCheckBox(text);
        cb.setFont(font);
        return cb;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new reg());
    }
}
