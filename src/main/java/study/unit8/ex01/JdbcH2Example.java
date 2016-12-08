package study.unit8.ex01;

import java.sql.*;

public class JdbcH2Example {
    public static void main(String[] args) throws ClassNotFoundException {
        final String url = "jdbc:h2:mem:";
        Class.forName("org.h2.Driver");

        try (Connection connection = DriverManager.getConnection(url)) {
            connection.createStatement().execute(
                    "CREATE TABLE stationery (" +
                            "stat_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                            "name VARCHAR(255) NOT NULL," +
                            "price INT NOT NULL)");

            PreparedStatement insertStatment =
                    connection.prepareStatement("INSERT INTO stationery (name, price) VALUES (?,?)");
            insertStatment.setString(1, "Pencil");
            insertStatment.setInt(2, 10);
            insertStatment.execute();
            insertStatment.setString(1, "Notepad");
            insertStatment.setInt(2, 20);
            insertStatment.execute();
            insertStatment.setString(1, "Stapler");
            insertStatment.setInt(2, 45);
            insertStatment.execute();

            connection.createStatement().execute(
                    "UPDATE stationery SET price=price+10"
            );
            connection.createStatement().execute(
                    "UPDATE stationery SET price=5 WHERE stat_id=2"
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT stat_id, name, price FROM stationery");
            ResultSet result1 = statement.executeQuery();
            while (result1.next()) {
                System.out.printf("[%d][%s][%d]\n", result1.getInt(1), result1.getString(2), result1.getInt(3));
            }
            System.out.println();
            ResultSet result2=connection.createStatement().executeQuery(
                    "SELECT stat_id, name, price FROM stationery WHERE name='Notepad'"
            );
            while (result2.next()) {
                System.out.printf("[%d][%s][%d]\n", result2.getInt(1), result2.getString(2), result2.getInt(3));
            }

            connection.createStatement().execute(
                    "DROP TABLE IF EXISTS stationery"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
