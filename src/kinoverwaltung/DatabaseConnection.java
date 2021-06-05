package kinoverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "kinoverwaltung";
        String url = "jdbc:sqlite:C:/Users/erdmann/IdeaProjects/Kinoverwaltung/src/kinoverwaltung/kinoverwaltung.db";

        try {
            Class.forName("org.sqlite.JDBC");
            databaseLink = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;
    }

}
