package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import kinoverwaltung.*;
import model.MovieModel;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class MovieController implements Initializable {
    @FXML private TableView<MovieModel> movielist = new TableView<>();
    @FXML private TableColumn<MovieModel, String> colName;
    @FXML private TableColumn<MovieModel, Integer> colLength;
    @FXML private TableColumn<MovieModel, Byte> colFskApproval;
    ObservableList<MovieModel> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String sql = "select * from film;";
            ResultSet rs = DatabaseManager.getDatabaseManager().issueQuery(sql);
            while(rs.next()) {
                oblist.add(new MovieModel(rs.getInt("film_id"),
                                            rs.getString("name"),
                                            rs.getInt("lauflaenge_min"),
                                            rs.getByte("fsk_freigabe")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLength.setCellValueFactory(new PropertyValueFactory<>("lauflaengeMin"));
        colFskApproval.setCellValueFactory(new PropertyValueFactory<>("fskFreigabe"));

        movielist.setItems(oblist);
    }

    public void openShowings(ActionEvent event) throws Exception {
        Session s = Session.getInstance();
        MovieModel m = movielist.getSelectionModel().getSelectedItem();
        if(m != null) {
            try {
                s.setCurrentMovie(m);
                System.out.println(s.getCurrentMovie().getId());
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxml/show-list.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
