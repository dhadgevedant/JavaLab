import java.sql.*;
import java.util.Scanner;

public class StudentDatabaseApp {
    static String DB_URL = "jdbc:mysql://localhost:3306/";
    static String DB_NAME = "school";
    static String DB_USER = "root"; // change if needed
    static String DB_PASSWORD = ""; // change if needed

    private static Connection conn;

    public static void main(String[] args) {
        try {
            // Connect to MySQL server (no DB selected yet)
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            createDatabaseAndTable();

            // Reconnect using the new database
            conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Student Database Menu ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> addStudent(scanner);
                    case 2 -> viewStudents();
                    case 3 -> System.out.println("Exiting program.");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 3);

            scanner.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabaseAndTable() throws SQLException {
        Statement stmt = conn.createStatement();

        // Create database if not exists
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);

        // Connect to the new database to create table
        Connection tempConn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
        Statement tableStmt = tempConn.createStatement();
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS students (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100),
                    roll_number VARCHAR(20),
                    class VARCHAR(20)
                )
                """;
        tableStmt.executeUpdate(createTableSQL);
        tableStmt.close();
        tempConn.close();
    }

    private static void addStudent(Scanner scanner) {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter roll number: ");
            String rollNumber = scanner.nextLine();

            System.out.print("Enter class: ");
            String studentClass = scanner.nextLine();

            String sql = "INSERT INTO students (name, roll_number, class) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, rollNumber);
            stmt.setString(3, studentClass);
            stmt.executeUpdate();

            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewStudents() {
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Roll No: %s | Class: %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("roll_number"),
                        rs.getString("class"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
