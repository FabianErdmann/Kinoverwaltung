package kinoverwaltung;

import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;

public class DatabaseManager {
    private Connection conn;
    private static DatabaseManager db;

    private DatabaseManager() {
        String databaseName = "kinoverwaltung";
        String url = "jdbc:sqlite:C:/Users/erdmann/IdeaProjects/Kinoverwaltung/src/kinoverwaltung/kinoverwaltung.db";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DatabaseManager getDatabaseManager() {
        if(DatabaseManager.db == null)
            DatabaseManager.db = new DatabaseManager();
        return DatabaseManager.db;
    }

    public ResultSet issueQuery(String query) {
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean issueStatement(String statement) {
        try {
            Statement stat = conn.createStatement();
            stat.execute(statement);
            stat.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
