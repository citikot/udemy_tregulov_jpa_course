package online.agatstudio.crud.jdbc_entry;

import online.agatstudio.crud.jdbc_entry.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert_v3_getting_id {

    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;

        Student student = new Student("Isaak", "Sharp", 8.7);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students(name, surname, avg_grade) VALUES (?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Failed to add new student to database!");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                student.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("Failed to create student Id!");
            }

            System.out.println(student);
            statement.close();
            generatedKeys.close();
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
