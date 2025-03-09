package online.agatstudio.jdbc_entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate {

    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String enteredName = scanner.nextLine();
//            Statement statement = connection.createStatement();
//            String sqlQuery = "UPDATE students SET avg_grade = 5.2 " +
//                    "WHERE name = '" + enteredName + "'";
//            statement.executeUpdate(sqlQuery);
//            statement.close();

            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE students SET avg_grade = 10.0 WHERE name = ?");
            statement.setString(1, enteredName);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
