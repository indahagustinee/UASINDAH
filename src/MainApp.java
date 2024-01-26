import view.KamarInfoHotelView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    public JTextField usernameField;
    public JPasswordField isipassword;
    public JButton tombolLogin;
    public MainApp() {

        super("Password Input");
        //username
        JLabel usernameLabel = new JLabel("Username :");
        usernameField = new  JTextField();
        usernameField.setColumns(15);
        // Set the preferred width of the fields
        JLabel passworLabel = new JLabel("\nPassword : ");
        isipassword = new JPasswordField();
        isipassword.setColumns(15);
        tombolLogin = new JButton("Login");
        // Set layout (you can choose a layout manager based on your UI design)
        setLayout(new java.awt.FlowLayout());
        add(usernameLabel);
        add(usernameField);
        add(passworLabel);
        add(isipassword);
        add(tombolLogin);
        // Set up action listener for the login button
        tombolLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // For simplicity, check if username and password are both "admin"
                if ("admin".equals(usernameField.getText()) && "admin".equals(new String(isipassword.getPassword()))) {
                    // If login is successful, open the KamarInfoHotelView
                    dispose();  // Close the login window
                    openKamarInfoHotelView();
                } else {
                    JOptionPane.showMessageDialog(MainApp.this, "Invalid username or password");
                }
            }
        });
        // Set frame properties
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setTitle("Login");
        setVisible(true);
    }
    private void openKamarInfoHotelView() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KamarInfoHotelView().viewKamarInfoHotel();
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp();
            }
        });
    }
}
