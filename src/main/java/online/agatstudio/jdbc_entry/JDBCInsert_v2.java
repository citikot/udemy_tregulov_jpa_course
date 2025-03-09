package online.agatstudio.jdbc_entry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert_v2 {

    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Connection connection = null;

        Student student = new Student("Leo", "Farrell", 8.4);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PWD);
            Statement statement = connection.createStatement();

            // INSERT INTO students(name, surname, avg_grade) VALUES ("Leo", "Farrell", 8.4)

//            String sqlQuery = "INSERT INTO students(name, surname, avg_grade) VALUES " +
//                    "('" +
//                    student.getName() +
//                    "', '" +
//                    student.getSurname() +
//                    "', " +
//                    student.getAvgGrade() +
//                    ")";

            String sqlQuery = "INSERT INTO students(name, surname, avg_grade) VALUES ('Julia', 'Dean', 8.7)";
            statement.executeUpdate(sqlQuery);
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
