import javax.swing.*;
import java.awt.*;

public class swingApp extends JFrame {

    public swingApp() {
        setTitle("GUI Assignment");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        

        // JLabel label1 = new JLabel("Hello, World!");
        // label1.setHorizontalAlignment(JLabel.CENTER);
        // label1.setFont(new Font(Font.SANS_SERIF , Font.PLAIN|Font.ITALIC,  30));
        // add(label1);
        // setVisible(true);

        JLabel label2 = new JLabel("<html><body style='text-align:center; display:flex; flex-direction:column; justify-content:center; align-items:center;'><h1>Hello World</h1>Welcome to the first program in Java! Created using Swing. Dated April 23rd, 2025 <div style = 'background-color:green;'></div> </body></html>");
        label2.setHorizontalAlignment(JLabel.CENTER);
        // label2.setFont(new Font(Font.SANS_SERIF , Font.PLAIN,  15));
        add(label2);



        setVisible(true);
    }

    public static void main(String[] args) {
        new swingApp();
    }
}
