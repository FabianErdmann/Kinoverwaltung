package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import kinoverwaltung.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML private PasswordField passwordField;
    @FXML private TextField loginNameField;
    @FXML private Button loginBtn;

    @FXML private void loginButtonAction(ActionEvent event) {
        try {
            if(!loginNameField.getText().isEmpty()) {
                String sql =
                        "select * from kunde where benutzername = \""+loginNameField.getText().strip()+"\" and passwort = \""+passwordField.getText().strip()+"\"";

                ResultSet rs = DatabaseManager.getDatabaseManager().issueQuery(sql);
                System.out.println(rs.getInt("isAdmin"));

                //ResultSet is empty -> error dialog
                if(!rs.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Fehlerhaftes Login");
                    alert.setHeaderText("Fehler");
                    alert.setContentText("Nutzername oder Passwort falsch.");
                    alert.showAndWait();
                } else
                    openMovieListOrAdminCenter(rs.getInt("isAdmin"));

                rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openMovieListOrAdminCenter(int isAdmin) {
        String fxmlResource = "";
        if(isAdmin == 1)
            fxmlResource = "../fxml/admincenter.fxml";
        else
            fxmlResource = "../fxml/movie-list.fxml";
        System.out.println(fxmlResource);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlResource));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
